package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.*;
import com.yetta.pilipili.entity.*;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.ActivateInfoService;
import com.yetta.pilipili.service.EmailInfoService;
import com.yetta.pilipili.service.UserInfoService;
import com.yetta.pilipili.util.AESEncryption;
import com.yetta.pilipili.util.ErrorMsg;
import com.yetta.pilipili.util.GetIp;
import com.yetta.pilipili.util.MD5;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserProfileInfoMapper userProfileInfoMapper;

    @Autowired
    WebInfoMapper webInfoMapper;

    @Autowired
    EmailInfoService emailInfoService;

    @Autowired
    ActivateInfoService activateInfoService;

    @Autowired
    ActivateInfoMapper activateInfoMapper;

    @Autowired
    UserCookieInfoMapper userCookieInfoMapper;

    @Autowired
    ReplyInfoMapper replyInfoMapper;

    @Autowired
    CommentInfoMapper commentInfoMapper;

    @Autowired
    CollectionInfoMapper collectionInfoMapper;

    @Autowired
    HistoryInfoMapper historyInfoMapper;

    /**
     * 注册新用户
     * @param request
     * @return
     * @throws SystemException
     */
    @Override
    public Map<String, Object> register(HttpServletRequest request) throws SystemException {
        //1. 先获得注册参数
        String regLoginName=request.getParameter("loginName");
        String regPassWord=request.getParameter("passWord");
        String regEmail=request.getParameter("email");

        //2. 校验注册信息
        //2.1 校验账号是否填写
        if (StringUtils.isEmpty(regLoginName)){
            throw new SystemException(ErrorMsg.ERROR_100004);
        }
        //2.2 校验账号长度
        regLoginName.replaceAll("\\s*", "");//匹配任何空白字符
        if (regLoginName.length()<6||regLoginName.length()>10){
            throw new SystemException(ErrorMsg.ERROR_100005);
        }

        //2.3 校验密码是否填写
        if (StringUtils.isEmpty(regPassWord)){
            throw new SystemException(ErrorMsg.ERROR_100006);
        }

        //2.4 校验密码长度
        regPassWord.replaceAll("\\s*", "");
        if (regPassWord.length()<6||regPassWord.length()>16){
            throw new SystemException(ErrorMsg.ERROR_100007);
        }

        //2.5 校验邮箱是否填写
        if (StringUtils.isEmpty(regEmail)){
            throw new SystemException(ErrorMsg.ERROR_100008);
        }

        //2.6 校验账号是否被占用
        int count=0;
        count=countUser(regLoginName, null);
        if (count>0){
            throw new SystemException(ErrorMsg.ERROR_100009);
        }

        //2.7 校验邮箱是否被占用
        count=0;
        regEmail=regEmail.replaceAll("\\s*", "").toLowerCase();
        count=countUser(null, regEmail);
        if (count>0){
            throw new SystemException(ErrorMsg.ERROR_100010);
        }

        //3. 注册新用户
        String regIp= GetIp.getIp(request);
        Date currentTime=new Date();
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String now=format.format(currentTime);

        UserInfo userInfo=new UserInfo();
        userInfo.setLoginName(regLoginName);
        userInfo.setPassWord(MD5.md5(regPassWord));
        userInfo.setEmail(regEmail);
        userInfo.setRegisterTime(currentTime);
        userInfo.setRegisterIp(regIp);
        userInfo.setLastLoginTime(currentTime);
        userInfo.setLastLoginIp(regIp);
        userInfo.setStatus("0");//账号未激活

        userInfoMapper.insert(userInfo);

        UserProfileInfo userProfileInfo=new UserProfileInfo();
        userProfileInfo.setUserId(userInfo.getId());
        userProfileInfo.setGroupId(2);      //注册会员
        userProfileInfo.setPoint(0);        //积分0分

        userProfileInfoMapper.insert(userProfileInfo);

        //4.对用户信息进行加密,用于cookie储存
        int UID=userInfo.getId();    //用户ID
        //用户的登录名和密码
        String userToken= AESEncryption.getInstance().encrypt(regLoginName)+"&&"+AESEncryption.getInstance().encrypt(regPassWord);
        //将用户名和密码转为没有特殊字符的Base64编码
        userToken= Base64.encodeBase64String(userToken.getBytes());

        Map<String,Object> map=new HashMap<>();
        map.put("UID", UID);
        map.put("userToken", userToken);
        return map;
    }

    /**
     * 校验账号是否已经被注册
     * @param logName 注册时填写的账号
     * @param email 注册时填写的邮箱
     * @return
     */
    @Override
    public int countUser(String logName, String email) {
        return userInfoMapper.countUser(logName, email);
    }

    /**
     * 根据userTakon获取UserInfo信息
     * @param userToken
     * @return
     */
    @Override
    public UserInfo getUserByUserToken(String userToken) throws SystemException {
        //userToken从base64转化为String
        try {
            byte[] decodeBase64=Base64.decodeBase64(userToken);
            userToken=new String(decodeBase64);
        }
        catch (Exception e){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }
        String arr[]=userToken.split("&&");
        if (arr.length<=1){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        //AES解密logName和passWord
        String regLoginName=AESEncryption.getInstance().decript(arr[0]);
        String regPassWord=AESEncryption.getInstance().decript(arr[1]);

        UserInfo userInfo=selectUser(regLoginName, MD5.md5(regPassWord));
        if (userInfo==null){
            throw new SystemException(ErrorMsg.ERROR_100012);
        }

        return userInfo;
    }

    /**
     * 校验用户登录
     * @param logName 登录名
     * @param passWord  登录密码
     * @return
     */
    @Override
    public UserInfo selectUser(String logName, String passWord) {
        return userInfoMapper.selectUser(logName, passWord);
    }

    /**
     * 用户换绑邮箱验证
     * @param userInfo 用户信息
     * @param subject 邮件标题
     * @param type 验证类型
     * @throws SystemException
     */
    @Override
    public void sendEmail(UserInfo userInfo, String subject, String type) throws SystemException {

        WebInfo webInfo=webInfoMapper.select();
        String webName=webInfo.getName();

        //获取当前系统时间
        Date currentTime=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now=dateFormat.format(currentTime);

        String verificationCode= String.valueOf((int)((Math.random()*9+1)*100000));

        //生成邮件内容
        StringBuffer content=new StringBuffer();
        content.append("<div style='background:#f7f7f7;overflow:hidden'>");
        content.append("<div style='background:#fff;border:1px solid #ccc;margin:2%;padding:0 30px'>");
        content.append("<div style='line-height:40px;height:40px'>&nbsp;</div>");
        content.append("<p style='margin:0;padding:0;font-size:14px;line-height:30px;color:#333;font-family:arial,sans-serif;font-weight:bold'>亲爱的用户 <b style='font-size:18px;color:#f90'>"+userInfo.getLoginName()+"</b>：</p>");
        content.append("<div style='line-height:20px;height:20px'>&nbsp;</div>");
        content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>您好！感谢您使用"+webName+"服务，您正在进行邮箱验证，本次请求的验证码为：</p>");
        content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>");
        content.append("<b style='font-size:18px;color:#f90'>"+verificationCode+"</b>");
        content.append("<span style='margin:0;padding:0;margin-left:10px;line-height:30px;font-size:14px;color:#979797;font-family:'宋体',arial,sans-serif'>(为了保障您账号的安全性，请在1小时内完成验证。)</span>");
        content.append("</p>");
        content.append("<div style='line-height:80px;height:80px'>&nbsp;</div>");
        content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>"+webName+"团队</p>");
        content.append("<p style='margin:0;padding:0;line-height:30px;font-size:14px;color:#333;font-family:'宋体',arial,sans-serif'>"+now+"</p>");
        content.append("</div>");
        content.append("</div>");

        //发送验证邮件
        emailInfoService.sendEmail(userInfo.getEmail(), subject, content.toString());

        //生成验证码有效期
        ActivateInfo activateInfo=new ActivateInfo();
        activateInfo.setUserId(userInfo.getId());
        activateInfo.setType(type);//用户修改邮箱
        activateInfo.setCode(verificationCode);
        activateInfo.setCreateTime(currentTime);

        activateInfoService.save(activateInfo);

    }

    /**
     * 邮箱验证,激活账号
     * @param userInfo
     * @param identifyingCode
     * @throws SystemException
     */
    @Override
    public void validateEmail(UserInfo userInfo, String identifyingCode) throws SystemException {
        //1. 获取验证记录
        ActivateInfo activateInfo=activateInfoService.selectByUserIdAndType(userInfo.getId(), "register");

        if (activateInfo==null){
            throw new SystemException(ErrorMsg.ERROR_X00002);
        }

        //2. 校验
        //2.1 校验验证码是否正确
        if (!identifyingCode.equals(activateInfo.getCode())){
            throw new SystemException(ErrorMsg.ERROR_100014);
        }

        //校验验证码是否过期
        Date currentTime=new Date();
        Date verifyTime=activateInfo.getCreateTime();

        long diff=currentTime.getTime()-verifyTime.getTime();
        long hours=diff/(1000*60*60);
        if (hours>0){
            throw new SystemException(ErrorMsg.ERROR_100015);
        }

        //3. 修改用户状态
        userInfoMapper.update(userInfo);

        //4. 删除验证记录
        activateInfoMapper.delete(activateInfo.getId());

    }

    /**
     * 用户登录
     * @param request
     * @return
     * @throws SystemException
     */
    @Override
    public Map<String, Object> login(HttpServletRequest request) throws SystemException {
        //1. 获取用户登录参数
        String loginName=request.getParameter("loginName");
        String passWord=request.getParameter("passWord");

        //2. 校验用户
        //2.1 校验用户名或密码是否填写
        if (StringUtils.isEmpty(loginName)||StringUtils.isEmpty(passWord)){
            throw new SystemException(ErrorMsg.ERROR_100001);
        }

        //2.2 校验用户名或密码是否正确
        UserInfo userInfo=userInfoMapper.selectUser(loginName, MD5.md5(passWord));
        if (userInfo==null){
            throw new SystemException(ErrorMsg.ERROR_100002);
        }

        //2.3 校验用户状态是否正常
        if ("0".equals(userInfo.getStatus())){
            throw new SystemException(ErrorMsg.ERROR_100019);
        }
        if ("2".equals(userInfo.getStatus())){
            throw new SystemException(ErrorMsg.ERROR_100003);
        }

        //3. 将用户保存至session
        request.getSession().setAttribute("userInfo", userInfo);

        //4. 对用户信息进行加密,用户cookie存储
        //用户ID
        Integer UID=userInfo.getId();
        //用户凭据登录名和密码
        String userToken=AESEncryption.getInstance().encrypt(loginName)+"&&"+AESEncryption.getInstance().encrypt(passWord);

        //将用户名和密码转为没有特殊字符的base64编码
        userToken=Base64.encodeBase64String(userToken.getBytes());
        Map<String,Object> info=new HashMap<>();
        info.put("UID", UID);
        info.put("userToken", userToken);

        //用户自动登录
//        String[] rememberMe=request.getParameterValues("rememberMe");
//        if (rememberMe!=null&&rememberMe.length>0){
//            if (rememberMe[0].equals("on")){
//                Cookie cookieLoginName=new Cookie("autoLoginId",userInfo.getId().toString());
//                cookieLoginName.setMaxAge(60*60*24*7);
//                String sessionId=request.getSession().getId();
//                Cookie cookieSeesionId=new Cookie("sessionId",sessionId);
//                cookieSeesionId.setMaxAge(60*60*24*7);
//                Date currentTime=new Date();
//                UserCookieInfo userCookieInfo=new UserCookieInfo();
//                userCookieInfo.setUserId(userInfo.getId());
//                userCookieInfo.setSessionId(sessionId);
//                userCookieInfo.setCreateTime(currentTime);
//                userCookieInfoMapper.insert(userCookieInfo);
//            }
//        }
        return info;

    }


    /**
     * 用户找回密码,发送邮箱验证
     * @param email
     * @throws SystemException
     */
    @Override
    public void findPwdEmail(String email) throws SystemException {
        if (StringUtils.isEmpty(email)){
            throw new SystemException(ErrorMsg.ERROR_120008);
        }

        //验证邮箱是否存在
        UserInfo userInfo=userInfoMapper.selectUserByEmail(email);
        if (userInfo==null){
            throw new SystemException(ErrorMsg.ERROR_100018);
        }

        sendEmail(userInfo, "找回密码验证", "find_pwd");
    }

    /**
     * 用户找回密码,用来校验验证码
     * @param email 验证邮箱
     * @param identifyingCode 验证码
     * @throws SystemException
     */
    @Override
    public void findPwdCode(String email, String identifyingCode) throws SystemException {
        //1. 校验验证码是否正确
        ActivateInfo activateInfo=activateInfoMapper.selectByEmailAndCodeAndType(email, identifyingCode, "find_pwd");

        if (activateInfo==null){
            throw new SystemException(ErrorMsg.ERROR_100014);
        }

        //2. 校验验证码是否已过期
        Date currentTime=new Date();
        Date verifyTime=activateInfo.getCreateTime();

        long diff=currentTime.getTime()-verifyTime.getTime();
        long hours=diff/(1000*60*60);

        if (hours>0){
            throw new SystemException(ErrorMsg.ERROR_100015);
        }


    }

    /**
     * 用户自己设置新密码
     * @param email 邮箱地址
     * @param identifyingCode 验证码
     * @param passWord 新密码
     * @throws SystemException
     */
    @Override
    public void setNewPassWord(String email, String identifyingCode, String passWord) throws SystemException {

        if (StringUtils.isEmpty(passWord)){
            throw new SystemException(ErrorMsg.ERROR_100006);
        }

        passWord=passWord.replaceAll("\\s*", "");

        if (passWord.length()<6||passWord.length()>16){
            throw new SystemException(ErrorMsg.ERROR_100007);
        }

        ActivateInfo activateInfo=activateInfoMapper.selectByEmailAndCodeAndType(email, identifyingCode, "find_pwd");
        if(activateInfo==null){
            throw new SystemException(ErrorMsg.ERROR_100014);
        }

        //校验验证码是否过期
        Date currentTime=new Date();
        Date verifyTime=activateInfo.getCreateTime();

        long diff=currentTime.getTime()-verifyTime.getTime();
        long hours=diff/(1000*60*60);

        if (hours>0){
            throw new SystemException(ErrorMsg.ERROR_100015);
        }

        UserInfo userInfo=new UserInfo();
        userInfo.setId(activateInfo.getUserId());
        userInfo.setPassWord(MD5.md5(passWord));

        userInfoMapper.update(userInfo);
    }

    /**
     * 用户更改自己的邮箱
     * @param userInfo
     * @param identifyingCode 验证码
     * @throws SystemException
     */
    @Override
    public void changeEmail(UserInfo userInfo, String identifyingCode) throws SystemException {
        //1. 验证邮箱是否被占用
        int count=userInfoMapper.countByEmail(userInfo.getEmail());
        if (count>0){
            throw new SystemException(ErrorMsg.ERROR_100010);
        }

        //2. 获取验证记录
        ActivateInfo activateInfo=activateInfoMapper.selectByUserIdAndType(userInfo.getId(), "change_email");

        //3. 校验
        //3.1 校验验证码是否正确
        if (!identifyingCode.equals(activateInfo.getCode())){
            throw new SystemException(ErrorMsg.ERROR_100014);
        }

        //3.2 校验验证码是否过期
        Date currentTime=new Date();
        Date verifyTime=activateInfo.getCreateTime();

        long diff=currentTime.getTime()-verifyTime.getTime();
        long hours=diff/(1000*60*60);

        if (hours>0){
            throw new SystemException(ErrorMsg.ERROR_100015);
        }

        //4. 修改用户邮箱
        userInfoMapper.update(userInfo);

        //5. 删除验证记录
        activateInfoMapper.delete(activateInfo.getId());
    }

    /**
     * 用户修改自己的密码
     * @param userInfo
     */
    @Override
    public void changePassWord(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }


    /**
     *页面已加载就获取用户信息
     * @param request
     * @return
     */
    @Override
    public UserInfo getUserInfo(HttpServletRequest request) {
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

        if (!StringUtils.isEmpty(userToken)){
            //判断Session
            HttpSession session=request.getSession();

            UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");

            if (userInfo==null){
                try {
                    userInfo=getUserByUserToken(userToken);
                } catch (SystemException e) {
                    //用户凭据是伪造的
                    return null;
                }
            }
            return userInfo;
        }
        return null;
    }

    /**
     * 查询所有用户
     * @param param
     * @return
     */
    @Override
    public List<UserInfo> list(Map<String, Object> param) {
        return userInfoMapper.list(param);
    }

    /**
     * 保存用户信息
     * @param userInfo
     * @throws SystemException
     */
    @Override
    public void save(UserInfo userInfo) throws SystemException {
        if (StringUtils.isEmpty(userInfo.getId())) {
            // 新增
            // 1.0 获取注册参数
            String szLoginName = userInfo.getLoginName();
            String szPassWord = userInfo.getPassWord();
            String szEmail = userInfo.getEmail();

            // 2.0 校验注册信息
            // 2.1 校验账号是否填写
            if (StringUtils.isEmpty(szLoginName)) {
                throw new SystemException(ErrorMsg.ERROR_100004);
            }
            // 2.2 校验账号长度
            szLoginName = szLoginName.replaceAll("\\s*", "");
            if (szLoginName.length()<4 || szLoginName.length()>10) {
                throw new SystemException(ErrorMsg.ERROR_100005);
            }

            // 2.3 校验密码是否填写
            if (StringUtils.isEmpty(szPassWord)) {
                throw new SystemException(ErrorMsg.ERROR_100006);
            }
            // 2.4 校验密码长度
            szPassWord = szPassWord.replaceAll("\\s*", "");
            if (szPassWord.length()<6 || szPassWord.length()>16) {
                throw new SystemException(ErrorMsg.ERROR_100007);
            }

            // 2.5 校验邮箱是否填写
            if (StringUtils.isEmpty(szEmail)) {
                throw new SystemException(ErrorMsg.ERROR_100008);
            }

            int count = 0;
            // 2.6 校验账号是否已被占用
            count = countUser(szLoginName, null);
            if (count>0) {
                throw new SystemException(ErrorMsg.ERROR_100009);
            }
            // 2.7 校验邮箱是否已被占用
            szEmail = szEmail.replaceAll("\\s*", "").toLowerCase();
            count = countUser(null, szEmail);
            if (count>0) {
                throw new SystemException(ErrorMsg.ERROR_100010);
            }

            // 3.0 注册新用户
            // 获取当前时间
            Date currentTime = new Date();
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String now = formatter.format(currentTime);

            // 注册时间
            if (userInfo.getRegisterTime()!=null) {
                userInfo.setRegisterTime(currentTime);
            }

            // 上次访问时间
            if (userInfo.getLastLoginTime()!=null) {
                userInfo.setLastLoginTime(currentTime);
            }

            userInfo.setPassWord(MD5.md5(szPassWord));	// 密码加密
            userInfo.setStatus("1");	// 正常状态

            userInfoMapper.insert(userInfo);

            UserProfileInfo userProfileInfo = new UserProfileInfo();
            userProfileInfo.setUserId(userInfo.getId());
            userProfileInfo.setAvatar(userInfo.getAvatar());
            userProfileInfo.setGroupId(userInfo.getGroupId());
            userProfileInfo.setSignPersonal(userInfo.getSignPersonal());
            userProfileInfo.setPoint(userInfo.getPoint());

            userProfileInfoMapper.insert(userProfileInfo);
        } else {
            // 编辑
            if (!StringUtils.isEmpty(userInfo.getPassWord())) {
                userInfo.setPassWord(MD5.md5(userInfo.getPassWord()));	// 密码加密
                userInfoMapper.update(userInfo);
            }

            UserProfileInfo userProfileInfo = new UserProfileInfo();
            userProfileInfo.setUserId(userInfo.getId());
            userProfileInfo.setAvatar(userInfo.getAvatar());
            userProfileInfo.setGroupId(userInfo.getGroupId());
            userProfileInfo.setSignPersonal(userInfo.getSignPersonal());
            userProfileInfo.setPoint(userInfo.getPoint());

            userProfileInfoMapper.update(userProfileInfo);
        }
    }

    /**
     * 根据主键查询用户信息（后台管理专用）
     * @param id 用户id
     * @return
     */
    @Override
    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectById(id);
    }


    /**
     * 批量更换用户所在用户组
     * @param param
     */
    @Override
    public void batchChangeGroup(Map<String, Object> param) {
        userProfileInfoMapper.batchUpdate(param);
    }

    /**
     * 批量更新用户状态
     * @param param
     */
    @Override
    public void batchUpdateStatus(Map<String, Object> param) {
        userInfoMapper.batchUpdate(param);
    }

    /**
     * 批量删除封禁用户的内容
     * @param userIdArr 用户id数组
     * @param deleteArr 删除内容表名数组
     */
    @Override
    public void batchDeleteContent(Integer[] userIdArr, String[] deleteArr) {
        // 遍历需要删除哪些表的数据
        for (int i=0; i<deleteArr.length; i++) {
            if ("replay_info".equals(deleteArr[i])) {
                // 删除回复表中的内容
                replyInfoMapper.deleteByUserIdArr(userIdArr);
            } else if ("comment_info".equals(deleteArr[i])) {
                // 删除评论表中的内容
                commentInfoMapper.deleteByUserIdArr(userIdArr);
            } else if ("collection_info".equals(deleteArr[i])) {
                // 删除收藏表中的内容
                collectionInfoMapper.deleteByUserIdArr(userIdArr);
            } else if ("history_info".equals(deleteArr[i])) {
                // 删除历史浏览记录表中的内容
                historyInfoMapper.deleteByUserIdArr(userIdArr);
            }
        }
    }

}

