package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.TemplateInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TemplateInfoMapperTest {

    TemplateInfoMapper templateInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        templateInfoMapper=session.getMapper(TemplateInfoMapper.class);
    }

    @Test
    public void selectByType() {
        TemplateInfo templateInfo=templateInfoMapper.selectByType("pc");
        System.out.println(templateInfo.getName()+"  "+templateInfo.getType());
    }

    @Test
    public void update() {
        TemplateInfo templateInfo=new TemplateInfo();
        templateInfo.setName("ww");
        templateInfo.setId(3);
        templateInfo.setType("ry");
        templateInfoMapper.update(templateInfo);
    }

    @Test
    public void selectNameByType() {
        System.out.println(templateInfoMapper.selectNameByType("pc"));
    }
}