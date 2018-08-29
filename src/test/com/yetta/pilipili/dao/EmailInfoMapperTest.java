package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.EmailInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class EmailInfoMapperTest {

    EmailInfoMapper emailInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        emailInfoMapper=session.getMapper(EmailInfoMapper.class);
    }

    @Test
    public void list() {
        System.out.println(emailInfoMapper.list());
    }

    @Test
    public void insert() {
        EmailInfo emailInfo=new EmailInfo();
        emailInfo.setEmail("dsaodasodnaod");
        emailInfo.setPassword("dnsiandaosi");
        emailInfo.setPort(3306);
        emailInfo.setSmtp("NB SMTP");
        emailInfoMapper.insert(emailInfo);
    }

    @Test
    public void update() {
        EmailInfo emailInfo=new EmailInfo();
        emailInfo.setEmail("dsaodasodnaod");
        emailInfo.setPassword("dnsiandaosi");
        emailInfo.setPort(8080);
        emailInfo.setSmtp("NB SMTP");
        emailInfo.setId(1);
        emailInfoMapper.update(emailInfo);
    }

    @Test
    public void delete() {
        Integer a[]=new Integer[]{4,5};
        emailInfoMapper.delete(a);
    }

    @Test
    public void selectById() {
        EmailInfo emailInfo=emailInfoMapper.selectById(1);
        System.out.println(emailInfo.getPort());
    }
}