package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.WebInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class WebInfoMapperTest {

    WebInfoMapper webInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        webInfoMapper=session.getMapper(WebInfoMapper.class);
    }

    @Test
    public void select() {
        WebInfo webInfo=webInfoMapper.select();
        System.out.println(webInfo.getDomain()+"  "+webInfo.getRecordNumber());
    }

    @Test
    public void update() {
        WebInfo webInfo=new WebInfo();
        webInfo.setDomain("dadpap");
        webInfo.setEmail("dadpap");
        webInfo.setName("dadpap");
        webInfo.setRecordNumber("dadpap");
        webInfo.setStatisticalCode("dadpap");
        webInfoMapper.update(webInfo);
    }
}