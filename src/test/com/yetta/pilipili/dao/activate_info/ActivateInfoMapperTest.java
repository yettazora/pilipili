package com.yetta.pilipili.dao.activate_info;

import com.yetta.pilipili.entity.ActivateInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

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

    }

    @Test
    public void insert() throws ParseException {
        ActivateInfo activateInfo=new ActivateInfo();
        activateInfo.setCode("naovn9qnvq02nfoqfqo");
        activateInfo.setCreateTime(new SimpleDateFormat("yy-MM-dd HH:mm:ss").parse(new Date().toString()));
        System.out.println(new SimpleDateFormat("yy-MM-dd HH:mm:ss").parse(new Date().toString()));
        activateInfo.setType("短信");
        activateInfo.setUserId(1);
        activateInfoMapper.insert(activateInfo);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void selectByEmailAndCodeAndType() {
    }
}