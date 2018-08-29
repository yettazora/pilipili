package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.service.SeoInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SeoInfoServiceImplTest {

    @Test
    public void selectByType() {
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SeoInfoService seoInfoService= (SeoInfoService) applicationContext.getBean("seoInfoService");
        System.out.println(seoInfoService.selectByType("index"));

    }

    @Test
    public void save() {
    }
}