package com.yetta.pilipili.dao;

import com.yetta.pilipili.dao.ActivateInfoMapper;
import com.yetta.pilipili.entity.ActivateInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.Date;

public class ActivateInfoMapperTest {

    ActivateInfoMapper activateInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        activateInfoMapper=session.getMapper(ActivateInfoMapper.class);
    }

    @Test
    public void selectByUserIdAndType() {
        System.out.println(activateInfoMapper.selectByUserIdAndType(1, "短信"));
    }

    @Test
    public void insert() throws ParseException {
        ActivateInfo activateInfo=new ActivateInfo();
        activateInfo.setCode("naovn9qnvq02nfoqfqo");
        activateInfo.setCreateTime(new Date());
        System.out.println(new Date());
        activateInfo.setType("短信");
        activateInfo.setUserId(1);
        activateInfoMapper.insert(activateInfo);
    }

    @Test
    public void update() {
        ActivateInfo activateInfo=new ActivateInfo();
        activateInfo.setCode("afinofnaopfnoangpaon");
        activateInfo.setCreateTime(new Date());
        System.out.println(new Date());
        activateInfo.setType("邮箱");
        activateInfo.setUserId(1);
        activateInfo.setId(2);
        activateInfoMapper.update(activateInfo);
    }

    @Test
    public void delete() {
        activateInfoMapper.delete(6);
    }

    @Test
    public void selectByEmailAndCodeAndType() {
        System.out.println(activateInfoMapper.selectByEmailAndCodeAndType("123456@qq.com", "afinofnaopfnoangpaon", "邮箱"));
    }
}