package com.yetta.pilipili.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yetta.pilipili.entity.CommentInfo;
import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.CommentInfoService;
import com.yetta.pilipili.service.UserInfoService;
import com.yetta.pilipili.util.ErrorMsg;
import com.yetta.pilipili.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/portal/comment_info")
public class CommentInfoController {

    @Autowired
    CommentInfoService commentInfoService;

    @Autowired
    UserInfoService userInfoService;

    /**
     * 获取某个视频的评论数
     *
     * @param videoId 视频ID主键
     * @return
     */
    @RequestMapping("/get_comment_count.json")
    @ResponseBody
    public Result getCommentCount(@RequestParam("videoId") String videoId) {

        int count = commentInfoService.getCnmmentCount(Integer.valueOf(videoId));

        return Result.success().add("count", count);
    }

    @RequestMapping("get_comment_list.json")
    @ResponseBody
    public Result getCommentList(@RequestParam("videoId") Integer videoId, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        //pageHelper分页插件
        //只需要在查询之前调用,传入当前页码,以及每一页显示多少条
        PageHelper.startPage(pageNum, pageSize);

        List<CommentInfo> list = commentInfoService.listByVideoId(videoId);

        PageInfo<CommentInfo> pageInfo = new PageInfo<CommentInfo>(list);

        return Result.success().add("pageInfo", pageInfo);
    }

    /**
     * 保存用户评论
     *
     * @param videoId
     * @param userToken
     * @param content
     * @param request
     * @return
     * @throws SystemException
     */
    @RequestMapping("/save.json")
    @ResponseBody
    public Result save(@RequestParam("videoId") Integer videoId, @RequestParam("userToken") String userToken, @RequestParam("content") String content
            , HttpServletRequest request) throws SystemException {

        //检查用户是否登录
        if (StringUtils.isEmpty(userToken)) {
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        //判断Session
        HttpSession session = request.getSession();
        //从Session中取出userInfo
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        if (userInfo == null) {
            userInfo = userInfoService.getUserByUserToken(userToken);
            //将用户信息保存至Session
            request.getSession().setAttribute("userInfo", userInfo);
        }


        commentInfoService.save(videoId, content, userInfo);

        return Result.success();
    }
}
