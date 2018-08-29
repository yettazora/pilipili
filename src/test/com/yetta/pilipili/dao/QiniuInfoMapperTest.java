package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.QiniuInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class QiniuInfoMapperTest {

    QiniuInfoMapper qiniuInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        qiniuInfoMapper=session.getMapper(QiniuInfoMapper.class);
    }

    @Test
    public void selectByType() {
        System.out.println(qiniuInfoMapper.selectByType("lmmlml"));
    }

    @Test
    public void update() {
        QiniuInfo qiniuInfo=new QiniuInfo();
        qiniuInfo.setAk("dsadadad");
        qiniuInfo.setBucket("dsadadad");
        qiniuInfo.setCompress(1);
        qiniuInfo.setDomain("dsadadad");
        qiniuInfo.setHeight(1);
        qiniuInfo.setId(233);
        qiniuInfo.setName("dsadadad");
        qiniuInfo.setSk("dsadadad");
        qiniuInfo.setType("lmmlml");
        qiniuInfo.setWidth(1);
        qiniuInfoMapper.update(qiniuInfo);
    }
}