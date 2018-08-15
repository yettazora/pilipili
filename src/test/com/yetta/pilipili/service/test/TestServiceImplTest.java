package com.yetta.pilipili.service.test;

import com.yetta.pilipili.dao.test.TestDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TestServiceImplTest {

    @Test
    public void selectById() {
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory factory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=factory.openSession();
        TestDao testDao=session.getMapper(TestDao.class);
        testDao.selectById(1);
    }
}