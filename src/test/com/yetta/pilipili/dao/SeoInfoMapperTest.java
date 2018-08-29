package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.SeoInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SeoInfoMapperTest {

    SeoInfoMapper seoInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        seoInfoMapper=session.getMapper(SeoInfoMapper.class);
    }

    @Test
    public void selectByType() {
        SeoInfo seoInfo=seoInfoMapper.selectByType("index");
        System.out.println(seoInfo.getKeywords()+seoInfo.getId()+"   "+seoInfo.getType());
    }

    @Test
    public void update() {
        SeoInfo seoInfo=new SeoInfo();
        seoInfo.setKeywords("cscmspa");
        seoInfo.setTitle("qqqqqqqqqqqqqq");
        seoInfo.setType("wff");
        seoInfoMapper.update(seoInfo);
    }
}