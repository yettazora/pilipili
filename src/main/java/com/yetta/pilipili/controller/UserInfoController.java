package com.yetta.pilipili.controller;

import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.entity.WebInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.UserInfoService;
import com.yetta.pilipili.service.WebInfoService;
import com.yetta.pilipili.util.ErrorMsg;
import com.yetta.pilipili.util.MD5;
import com.yetta.pilipili.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/portal/user_info")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    WebInfoService webInfoService;

    /**
     * 用户注册
     * @param request
     * @return
     */
    @RequestMapping("/register.json")
    @ResponseBody
    public Result register(HttpServletRequest request) throws SystemException {
        Map<String,Object> info=userInfoService.register(request);
        return Result.success().add("info", info);
    }

    /**
     * 用户注册时,邮箱验证
     * @param request
     * @param userToken 用户凭据
     * @return
     * @throws SystemException
     */
    @RequestMapping("/register_email.json")
    @ResponseBody
    public Result registerEmail(HttpServletRequest request, @RequestParam("userToken") String userToken) throws SystemException {
        if (StringUtils.isEmpty(userToken)){
            throw new SystemException(ErrorMsg.ERROR_100011);
        }

        UserInfo userInfo=userInfoService.getUserByUserToken(userToken);

        userInfoService.sendEmail(userInfo, "注册邮箱验证", "register");
        return Result.success();
    }

    /**
     * 邮箱验证,激活账号
     * @param request
     * @param identifyingCode 验证码
     * @param userToken 用户凭据
     * @return
     * @throws SystemException
     */
    @RequestMapping("/validate_email.json")
    @ResponseBody
    public Result validateEmail(HttpServletRequest request,@RequestParam("identifyingCode") String identifyingCode,@RequestParam("userToken") String userToken) throws SystemException {
        //校验验证码
        if (StringUtils.isEmpty(identifyingCode)){
            throw new SystemException(ErrorMsg.ERROR_100013);
        }

        //校验用户凭证
        if (StringUtils.isEmpty(userToken)){
            throw new SystemException(ErrorMsg.ERROR_100011);
        }

        //取出用户信息
        UserInfo userInfo=userInfoService.getUserByUserToken(userToken);

        UserInfo userInfo2=new UserInfo();
        userInfo2.setId(userInfo.getId());
        userInfo2.setStatus("1"); //激活此账号

        userInfoService.validateEmail(userInfo2, identifyingCode);

        //将用户信息保存至session
        request.getSession().setAttribute("userInfo", userInfo);

        return Result.success();
    }


    /**
     * 用户登录
     * @param request
     * @return
     * @throws SystemException
     */
    @RequestMapping("/login.json")
    @ResponseBody
    public Result login(HttpServletRequest request) throws SystemException {
        Map<String,Object> info=userInfoService.login(request);
        return Result.success().add("info", info);
    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @RequestMapping("/logout.json")
    @ResponseBody
    public Result logout(HttpSession session){
        //清除session
        session.invalidate();
        return Result.success();
    }

    /**
     * 用户找回密码,发送邮箱验证码
     * @param email 用户填写的邮箱地址
     * @return
     * @throws SystemException
     */
    @RequestMapping("/find_pwd_email.json")
    @ResponseBody
    public Result findPwdEmail(@RequestParam("email") String email) throws SystemException {

        userInfoService.findPwdEmail(email);
        return Result.success();
    }


    /**
     * 用户找回密码,填写校验验证码
     * @param email 填写邮箱地址
     * @param identifyingCode 验证码
     * @return
     * @throws SystemException
     */
    @RequestMapping("/find_pwd_code.json")
    @ResponseBody
    public Result findPwdCode(@RequestParam("email") String email,@RequestParam("identifyingCode") String identifyingCode) throws SystemException {
        userInfoService.findPwdCode(email, identifyingCode);

        return Result.success();
    }

    /**
     *
     * @param email
     * @param identifyingCode
     * @param passWord
     * @return
     * @throws SystemException
     */
    @RequestMapping("/set_new_pass_word.json")
    @ResponseBody
    public Result setNewPassWord(@RequestParam("email") String email,@RequestParam("identifyingCode") String identifyingCode,@RequestParam("passWord") String passWord) throws SystemException {
        userInfoService.setNewPassWord(email, identifyingCode, passWord);
        return Result.success();
    }


    @RequestMapping("/accountset.action")
    public String accountset(ModelMap modelMap, HttpServletRequest request){
        //站点信息
        WebInfo webInfo=webInfoService.select();
        modelMap.put("webInfo", webInfo);

        String userToken="";
        Cookie[] cookies=request.getCookies();
        if (cookies!=null&&cookies.length>0){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie=cookies[i];
                if ("userToken".equals(cookie.getName())){
                    try {
                        userToken= URLDecoder.decode(cookie.getValue(), "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        break;
                    }
                    break;
                }
            }

        }

        //如果用户没有登录就跳转到登录页面
        if (StringUtils.isEmpty(userToken)){
            return "user/login_page";
        }

        //判断session
        HttpSession session=request.getSession();

        UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");

        if (userInfo==null){
            try {
                userInfo=userInfoService.getUserByUserToken(userToken);
                //将用户信息保存至session
                request.getSession().setAttribute("userInfo", userInfo);
            } catch (SystemException e) {
                //用户凭据是伪造的,跳转到登录页面
                return "user/login_page";
            }
        }

        return "user/accountset";
    }


    /**
     * 用户换绑邮箱时，向旧邮箱发送验证码
     * @param request
     * @param userToken 用户凭证
     * @return
     * @throws SystemException
     */
    @RequestMapping("/send_email.json")
    @ResponseBody
    public Result sendEmail(HttpServletRequest request,@RequestParam("userToken") String userToken) throws SystemException {
        if (StringUtils.isEmpty(userToken)){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        //判断session
        HttpSession session=request.getSession();
        //获取userInfo
        UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");

        if (userInfo==null){
            userInfo=userInfoService.getUserByUserToken(userToken);

            //将用户信息保存至Session
            request.getSession().setAttribute("userInfo", userInfo);
        }

        userInfoService.sendEmail(userInfo, "换绑邮箱验证", "change_email");

        return Result.success();
    }


    /**
     * 用户修改自己的邮箱
     * @param request
     * @param email 新的邮箱地址
     * @param identifyingCode 验证码
     * @param userTken 用户凭证
     * @return
     * @throws SystemException
     */
    @RequestMapping("/change_email.json")
    @ResponseBody
    public Result changeEmail(HttpServletRequest request,@RequestParam("email")String email,@RequestParam("identifyingCode") String identifyingCode,@RequestParam("userToken") String userTken) throws SystemException {

        //校验邮箱
        if (StringUtils.isEmpty(email)){
            throw new SystemException(ErrorMsg.ERROR_100008);
        }

        //校验验证码
        if (StringUtils.isEmpty(identifyingCode)){
            throw new SystemException(ErrorMsg.ERROR_100013);
        }

        //校验用户凭证
        if (StringUtils.isEmpty(userTken)){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        //判断ssession
        HttpSession session=request.getSession();

        //从session中取出用户信息
        UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");
        if (userInfo==null){
            userInfo=userInfoService.getUserByUserToken(userTken);
            //将用户信息存入session
            request.getSession().setAttribute("userInfo", userInfo);
        }

        if (email.equals(userInfo.getEmail())){
            throw new SystemException(ErrorMsg.ERROR_100016);
        }

        UserInfo userInfo2=new UserInfo();
        userInfo2.setId(userInfo.getId());
        userInfo2.setEmail(email);

        userInfoService.changeEmail(userInfo2, identifyingCode);

        //将用户信息重新保存至session
        userInfo=userInfoService.getUserByUserToken(userTken);
        request.getSession().setAttribute("userInfo", userInfo);
        return Result.success();
    }

    /**
     * 用户修改自己的密码
     * @return
     */
    @RequestMapping("/change_pass_word.json")
    @ResponseBody
    public Result changePassWord(HttpServletRequest request,@RequestParam("passWord") String passWord,@RequestParam("userToken") String userToken) throws SystemException {

        if (StringUtils.isEmpty(userToken)){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        if (StringUtils.isEmpty(passWord)){
            throw new SystemException(ErrorMsg.ERROR_100006);
        }

        //判断Session
        HttpSession session=request.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");

        if (userInfo==null){
            userInfo=userInfoService.getUserByUserToken(userToken);
            //将用户信息保存至Session
            request.getSession().setAttribute("userInfo", userInfo);
        }

        //设置用户，修改密码信息
        UserInfo userInfo2=new UserInfo();
        userInfo2.setId(userInfo.getId());
        userInfo2.setPassWord(MD5.md5(passWord));

        userInfoService.changePassWord(userInfo2);

        return Result.success();
    }
}
