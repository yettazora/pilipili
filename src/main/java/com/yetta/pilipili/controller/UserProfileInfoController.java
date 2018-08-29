package com.yetta.pilipili.controller;

import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.entity.UserProfileInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.UserInfoService;
import com.yetta.pilipili.service.UserProfileInfoService;
import com.yetta.pilipili.util.ErrorMsg;
import com.yetta.pilipili.util.Result;
import com.yetta.pilipili.util.SaveImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/portal/user_profile_info")
public class UserProfileInfoController {


    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserProfileInfoService userProfileInfoService;

    /**
     * 跳转到头像修改页面
     * @return
     */
    @RequestMapping("change_avatar.action")
    public String changeAvatar(){
        return "user/avatar";
    }

    /**
     * 保存用户头像
     * @param request
     * @param avatar
     * @param userToken
     * @return
     * @throws SystemException
     * @throws IOException
     */
    @RequestMapping("save_avatar.json")
    @ResponseBody
    public Result saveAvatar(HttpServletRequest request, @RequestParam("avatar") String avatar,@RequestParam("userToken") String userToken) throws SystemException, IOException {
        if (StringUtils.isEmpty(userToken)){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        //判断Session
        HttpSession session=request.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");

        if (userInfo==null){
            userInfo=userInfoService.getUserByUserToken(userToken);
            //将用户信息保存至session
            request.getSession().setAttribute("userInfo", userInfo);
        }

        //存储头像到本地
        avatar= SaveImg.save(avatar);

        //保存用户头像
        UserProfileInfo userProfileInfo=new UserProfileInfo();
        userProfileInfo.setAvatar(avatar);
        userProfileInfo.setUserId(userInfo.getId());
        userProfileInfoService.save(userProfileInfo);

        //重新设置session
        userInfo=userInfoService.getUserByUserToken(userToken);
        request.getSession().setAttribute("userInfo", userInfo);
        return Result.success().add("imgUrl", avatar);
    }
}
