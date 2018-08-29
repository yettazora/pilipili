package com.yetta.pilipili.controller;

import com.yetta.pilipili.entity.ReplyInfo;
import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.ReplyInfoService;
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
import java.util.Date;

@Controller
@RequestMapping("/portal/reply_info")
public class ReplyInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ReplyInfoService replyInfoService;
    /**
     * 保存用户的回复
     * @param videoId 视频主键
     * @param commentId 评论主键
     * @param userToken 用户凭据
     * @param toUserId 被回复的用户ID
     * @param toLoginName 被回复的用户名
     * @param content 回复内容
     * @param request request
     * @return
     * @throws SystemException
     */
    @RequestMapping("/save.json")
    @ResponseBody
    public Result save(@RequestParam("videoId") Integer videoId, @RequestParam("commentId")Integer commentId, @RequestParam("userToken") String userToken
    , @RequestParam("toUserId") Integer toUserId, @RequestParam("toLoginName") String toLoginName, @RequestParam("content")String content, HttpServletRequest request) throws SystemException {

        //检查用户是否登录
        if (StringUtils.isEmpty(userToken)){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        //校验Session
        HttpSession session=request.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");

        if (userInfo==null){
            userInfo=userInfoService.getUserByUserToken(userToken);
            //将用户信息保存至session
            request.getSession().setAttribute("userInfo",userInfo);
        }

        //用户无法自己对自己回复
        if (toUserId==userInfo.getId()){
            throw new SystemException(ErrorMsg.ERROR_900002);
        }

        //校验内容是否为空
        if (StringUtils.isEmpty(content)){
            throw new SystemException(ErrorMsg.ERROR_900001);
        }

        // 删除普通标签
//        content = content.replaceAll("<(S*?)[^>]*>.*?|<.*? />", "");
        // 删除转义字符
//        content = content.replaceAll("&.{2,6}?;", "");

        Date currentTime=new Date();
        ReplyInfo replyInfo=new ReplyInfo();
        replyInfo.setVideoId(videoId);
        replyInfo.setUserId(userInfo.getId());
        replyInfo.setUpdateTime(currentTime);
        replyInfo.setToUserId(toUserId);
        replyInfo.setToLoginName(toLoginName);
        replyInfo.setLoginName(userInfo.getLoginName());
        replyInfo.setContent(content);
        replyInfo.setCommentId(commentId);


        replyInfoService.save(replyInfo);
        return Result.success();
    }

}