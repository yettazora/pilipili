package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.StarInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class StarInfoMapperTest {

    StarInfoMapper starInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        starInfoMapper=session.getMapper(StarInfoMapper.class);
    }

    @Test
    public void list() {
        System.out.println(starInfoMapper.list());
    }

    @Test
    public void selectById() {
        StarInfo starInfo=starInfoMapper.selectById(1);
        System.out.println(starInfo.getName()+"  "+starInfo.getBlood());
    }

    @Test
    public void insert() {
        StarInfo starInfo=new StarInfo();
        starInfo.setAlias("aaaaaaaaaaaa");
        starInfo.setBirthday("aaaaaaaaaaaa");
        starInfo.setBlood("aaaaaaaaaaaa");
        starInfo.setConstellation("aaaaaaaaaaaa");
        starInfo.setImage("aaaaaaaaaaaa");
        starInfo.setIntroduction("aaaaaaaaaaaa");
        starInfo.setName("aaaaaaaaaaaa");
        starInfo.setOccupation("aaaaaaaaaaaa");
        starInfo.setRegion("aaaaaaaaaaaa");
        starInfo.setSex("aaaaaaaaaaaa");
        starInfoMapper.insert(starInfo);
    }

    @Test
    public void update() {
        StarInfo starInfo=new StarInfo();
        starInfo.setAlias("aaaaaaaaaaaa");
        starInfo.setBirthday("aaaaaaaaaaaa");
        starInfo.setBlood("aaaaaaaaaaaa");
        starInfo.setConstellation("aaaaaaaaaaaa");
        starInfo.setImage("aaaaaaaaaaaa");
        starInfo.setIntroduction("aaaaaaaaaaaa");
        starInfo.setName("aaaaaaaaaaaa");
        starInfo.setOccupation("aascscs");
        starInfo.setRegion("aabbbb");
        starInfo.setSex("bbbbb");
        starInfo.setId(1);
        starInfoMapper.update(starInfo);
    }
}