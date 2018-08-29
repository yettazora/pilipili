package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.EmailInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class EmailInfoServiceImplTest {

    @Test
    public void emailTest() throws SystemException {
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        EmailInfoServiceImpl emailInfoService= (EmailInfoServiceImpl) applicationContext.getBean("emailInfoService");
        emailInfoService.emailTest(5, "woyinzhen@yeah.net");
    }
}