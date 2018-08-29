package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.service.TemplateInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TemplateInfoServiceImplTest {

    @Test
    public void selectNameByType() {
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        TemplateInfoService templateInfoService= (TemplateInfoService) applicationContext.getBean("templateInfoService");
        System.out.println(templateInfoService.selectNameByType("pc"));
    }
}