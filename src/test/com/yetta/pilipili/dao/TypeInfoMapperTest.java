package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.TypeInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TypeInfoMapperTest {

    TypeInfoMapper typeInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        typeInfoMapper=session.getMapper(TypeInfoMapper.class);
    }

    @Test
    public void list() {
        System.out.println(typeInfoMapper.list());
    }

    @Test
    public void insert() {
        TypeInfo typeInfo=new TypeInfo();
        typeInfo.setName("aaaaaaaa");
        typeInfo.setPlayTemplate("aaaaaaaa");
        typeInfo.setProfileTemplate("aaaaaaaa");
        typeInfo.setSort(1);
        typeInfoMapper.insert(typeInfo);
        typeInfoMapper.insert(typeInfo);
        typeInfoMapper.insert(typeInfo);
        typeInfoMapper.insert(typeInfo);
    }

    @Test
    public void update() {
        TypeInfo typeInfo=new TypeInfo();
        typeInfo.setName("bbbbbb");
        typeInfo.setPlayTemplate("bbbbbbbbb");
        typeInfo.setProfileTemplate("bbbbbbb");
        typeInfo.setSort(1);
        typeInfo.setId(5);
        typeInfoMapper.update(typeInfo);
    }

    @Test
    public void delete() {
        typeInfoMapper.delete(new Integer[]{2,3});
    }

    @Test
    public void selectById() {
        TypeInfo typeInfo=typeInfoMapper.selectById(1);
        System.out.println(typeInfo.getId()+" "+typeInfo.getName()+"  "+typeInfo.getProfileTemplate());
    }
}