package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.ChannelInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ChannelInfoMapperTest {

    ChannelInfoMapper channelInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        channelInfoMapper=session.getMapper(ChannelInfoMapper.class);
    }

    @Test
    public void list() {
        List<ChannelInfo> list=channelInfoMapper.list();
        System.out.println(list);
    }

    @Test
    public void insert() {
        ChannelInfo channelInfo=new ChannelInfo();
        channelInfo.setName("综艺");
        channelInfo.setSort(3);
        channelInfo.setKeywords("dd");
        channelInfo.setTemplate("nanosa");
        channelInfo.setTitle("dsa");
        channelInfo.setDescription("snaidnak");
        channelInfoMapper.insert(channelInfo);
    }

    @Test
    public void update() {
        ChannelInfo channelInfo=new ChannelInfo();
        channelInfo.setName("综艺");
        channelInfo.setSort(3333);
        channelInfo.setKeywords("cacsca");
        channelInfo.setTemplate("csacs");
        channelInfo.setTitle("a");
        channelInfo.setDescription("csacasc");
        channelInfo.setId(1);
        channelInfoMapper.update(channelInfo);
    }

    @Test
    public void selectById() {
        System.out.println(channelInfoMapper.selectById(1));
    }

    @Test
    public void delete() {
        channelInfoMapper.delete(3);
    }
}