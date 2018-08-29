package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.NavInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class NavInfoMapperTest {

    NavInfoMapper navInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        navInfoMapper=session.getMapper(NavInfoMapper.class);
    }

    @Test
    public void list() {
        System.out.println(navInfoMapper.list());
    }

    @Test
    public void insert() {
        NavInfo navInfo=new NavInfo();
        navInfo.setChannelId(1);
        navInfo.setIsIndex(1);
        navInfo.setIsUse(1);
        navInfo.setLink("dnasidnioasbdoi");
        navInfo.setName("dnajdiand");
        navInfo.setSort(123);
        navInfo.setType("daidao");
        navInfoMapper.insert(navInfo);
    }

    @Test
    public void update() {
        NavInfo navInfo=new NavInfo();
        navInfo.setChannelId(1);
        navInfo.setIsIndex(1);
        navInfo.setIsUse(1);
        navInfo.setLink("csacascascsa");
        navInfo.setName("csacascas");
        navInfo.setSort(233333);
        navInfo.setType("cascsacsa");
        navInfo.setId(2);
        navInfoMapper.update(navInfo);
    }

    @Test
    public void delete() {
        navInfoMapper.delete(new Integer[]{3});
    }

    @Test
    public void deleteByChannelId() {
        navInfoMapper.deleteByChannelId(1);
    }

    @Test
    public void listIsUse() {
        System.out.println(navInfoMapper.listIsUse());
    }

    @Test
    public void updateByChannel() {
        NavInfo navInfo=new NavInfo();
        navInfo.setChannelId(1);
        navInfo.setIsIndex(1);
        navInfo.setIsUse(1);
        navInfo.setLink("dnasidnioasbdoi");
        navInfo.setName("cl kasnvkas  nkkklvalslmvlsamv");
        navInfo.setSort(123);
        navInfo.setType("daidao");
        navInfoMapper.updateByChannel(navInfo);
    }
}