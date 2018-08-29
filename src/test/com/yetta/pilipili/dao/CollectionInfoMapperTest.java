package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.CollectionInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class CollectionInfoMapperTest {

    CollectionInfoMapper collectionInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        collectionInfoMapper=session.getMapper(CollectionInfoMapper.class);
    }

    @Test
    public void countByMediaIdAndUserId() {
        System.out.println(collectionInfoMapper.countByMediaIdAndUserId(1, 1));
    }

    @Test
    public void insert() {
        CollectionInfo collectionInfo=new CollectionInfo();
        collectionInfo.setMediaId(1);
        collectionInfo.setUserId(1);
        collectionInfoMapper.insert(collectionInfo);
    }

    @Test
    public void delete() {
        CollectionInfo collectionInfo=new CollectionInfo();
        collectionInfo.setMediaId(2);
        collectionInfo.setUserId(1);
        collectionInfoMapper.delete(collectionInfo);
    }

    @Test
    public void listCollection() {
        List list=collectionInfoMapper.listCollection(1);
        System.out.println(list);
    }

    @Test
    public void deleteByUserIdArr() {
        Integer a[]=new Integer[]{3,4};
        collectionInfoMapper.deleteByUserIdArr(a);
    }
}