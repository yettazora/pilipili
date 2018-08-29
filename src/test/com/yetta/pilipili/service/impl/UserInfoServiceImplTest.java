package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.service.UserInfoService;
import com.yetta.pilipili.util.MD5;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserInfoServiceImplTest {

    @Test
    public void selectUser() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-mybatis.xml");

        UserInfoService userInfoService= (UserInfoService) applicationContext.getBean("userInfoService");

        UserInfo userInfo=userInfoService.selectUser("814181683", MD5.md5("love1518"));

        System.out.println(userInfo);
    }
}