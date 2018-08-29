package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.exception.SystemException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserInfoService {
    Map<String,Object> register(HttpServletRequest request) throws SystemException;

    int countUser(String logName,String email);

    UserInfo getUserByUserToken(String userToken) throws SystemException;

    UserInfo selectUser(String logName,String passWord);

    void sendEmail(UserInfo userInfo,String subject,String type) throws SystemException;

    void validateEmail(UserInfo userInfo,String identifyingCode) throws SystemException;

    Map<String,Object> login(HttpServletRequest request) throws SystemException;

    void findPwdEmail(String email) throws SystemException;

    void findPwdCode(String email,String identifyingCode) throws SystemException;

    void setNewPassWord(String email,String identifyingCode,String passWord) throws SystemException;

    void changeEmail(UserInfo userInfo,String identifyingCode) throws SystemException;

    void changePassWord(UserInfo userInfo);

    UserInfo getUserInfo(HttpServletRequest request);

    List<UserInfo> list(Map<String, Object> param);

    void save(UserInfo userInfo) throws SystemException;

    UserInfo selectById(Integer id);

    void batchChangeGroup(Map<String, Object> param);

    void batchUpdateStatus(Map<String, Object> param);

    void batchDeleteContent(Integer[] idArr, String[] deleteArr);
}
