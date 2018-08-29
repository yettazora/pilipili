package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.HistoryInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class HistoryInfoMapperTest {

    HistoryInfoMapper historyInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        historyInfoMapper=session.getMapper(HistoryInfoMapper.class);
    }

    @Test
    public void insert() {
        HistoryInfo historyInfo=new HistoryInfo();
        historyInfo.setUpdateTime(new Date());
        historyInfo.setUserId(1);
        historyInfo.setVideoId(1);
        historyInfoMapper.insert(historyInfo);
    }

    @Test
    public void delete() {
        HistoryInfo historyInfo=new HistoryInfo();
        historyInfo.setUserId(1);
        historyInfo.setVideoId(3);
        historyInfoMapper.delete(historyInfo);
    }

    @Test
    public void listHistory5() {
        System.out.println(historyInfoMapper.listHistory5(1));
    }

    @Test
    public void listHistory() {
        System.out.println(historyInfoMapper.listHistory(1));
    }

    @Test
    public void deleteByUserIdArr() {
        historyInfoMapper.deleteByUserIdArr(new Integer[]{3,4});
    }
}