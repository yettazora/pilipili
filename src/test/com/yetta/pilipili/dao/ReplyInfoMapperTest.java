package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.ReplyInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReplyInfoMapperTest {

    ReplyInfoMapper replyInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        replyInfoMapper=session.getMapper(ReplyInfoMapper.class);
    }

    @Test
    public void insert() {
        ReplyInfo replyInfo=new ReplyInfo();
        replyInfo.setCommentId(1);
        replyInfo.setContent("dsnaidnaidn");
        replyInfo.setLoginName("dassdasda");
        replyInfo.setToLoginName("xamicnaioncoa");
        replyInfo.setToUserId(1);
        replyInfo.setUpdateTime(new Date());
        replyInfo.setUserId(1);
        replyInfo.setVideoId(1);
        replyInfoMapper.insert(replyInfo);
    }

    @Test
    public void listByCommentId() {
        List<ReplyInfo> replyInfos=replyInfoMapper.listByCommentId(1);
        ReplyInfo replyInfo=replyInfos.get(0);
        System.out.println(replyInfos.size());
        System.out.println(replyInfo.getCommentId()+"  "+replyInfo.getId()+"    "+replyInfo.getContent());
    }

    @Test
    public void countByVideoId() {
        System.out.println(replyInfoMapper.countByVideoId(1));
    }

    @Test
    public void deleteByUserIdArr() {
        System.out.println(replyInfoMapper.deleteByUserIdArr(new Integer[]{2}));
    }
}