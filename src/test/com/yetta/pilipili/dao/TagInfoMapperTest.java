package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.TagInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TagInfoMapperTest {

    TagInfoMapper tagInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        tagInfoMapper=session.getMapper(TagInfoMapper.class);
    }

    @Test
    public void listIdByNameArr() {
        System.out.println(tagInfoMapper.listIdByNameArr(new String[]{"samdmasodmaosdm"}));
    }

    @Test
    public void countByName() {
        System.out.println(tagInfoMapper.countByName("samdmasodmaosdm"));
    }

    @Test
    public void insert() {
        TagInfo tagInfo=new TagInfo();
        tagInfo.setName("samdmasodmaosdm");
        tagInfoMapper.insert(tagInfo);
    }

    @Test
    public void listNameByIdArr() {
        System.out.println(tagInfoMapper.listNameByIdArr(new Integer[]{1,2}));
    }
}