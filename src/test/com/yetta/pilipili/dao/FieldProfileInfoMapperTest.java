package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.FieldProfileInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class FieldProfileInfoMapperTest {

    FieldProfileInfoMapper fieldProfileInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        fieldProfileInfoMapper=session.getMapper(FieldProfileInfoMapper.class);
    }

    @Test
    public void listByFieldId() {
        System.out.println(fieldProfileInfoMapper.listByFieldId(3));
    }

    @Test
    public void insert() {
        FieldProfileInfo fieldProfileInfo=new FieldProfileInfo();
        fieldProfileInfo.setSort(13);
        fieldProfileInfo.setName("dsaomdoam");
        fieldProfileInfo.setFieldId(5);
        fieldProfileInfoMapper.insert(fieldProfileInfo);
    }

    @Test
    public void update() {
        FieldProfileInfo fieldProfileInfo=new FieldProfileInfo();
        fieldProfileInfo.setSort(100);
        fieldProfileInfo.setName("cssaccsa");
        fieldProfileInfo.setFieldId(6);
        fieldProfileInfo.setId(1);
        fieldProfileInfoMapper.update(fieldProfileInfo);
    }

    @Test
    public void delete() {
        fieldProfileInfoMapper.delete(new Integer[]{2,3});
    }

    @Test
    public void selectById() {
        String fieldProfileInfo=fieldProfileInfoMapper.selectById(6);
        System.out.println(fieldProfileInfo);
    }

    @Test
    public void selectByIdArr() {
        System.out.println(fieldProfileInfoMapper.selectByIdArr(new Integer[]{1,5,6}));
    }
}