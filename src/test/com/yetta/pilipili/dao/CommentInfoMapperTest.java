package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.CommentInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CommentInfoMapperTest {

    CommentInfoMapper commentInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        commentInfoMapper=session.getMapper(CommentInfoMapper.class);
    }

    @Test
    public void insert() {
        CommentInfo commentInfo=new CommentInfo();
        commentInfo.setContent("sdnaindsian");
        commentInfo.setVideoId(1);
        commentInfo.setUserId(1);
        commentInfo.setUpdateTime(new Date());
        commentInfo.setLoginName("dsmaodao");
        commentInfoMapper.insert(commentInfo);
    }

    @Test
    public void listByVideoId() {
        List list=commentInfoMapper.listByVideoId(1);
        CommentInfo c= (CommentInfo) list.get(1);
        System.out.println(c.getUpdateTime());
    }

    @Test
    public void countByVideoId() {
        System.out.println(commentInfoMapper.countByVideoId(1));
    }

    @Test
    public void deleteByUserIdArr() {
        Integer a[]=new Integer[]{2,3};
        commentInfoMapper.deleteByUserIdArr(a);
    }
}