package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.SlideInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SlideInfoMapperTest {

    SlideInfoMapper slideInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        slideInfoMapper=session.getMapper(SlideInfoMapper.class);
    }

    @Test
    public void listByApiId() {
        System.out.println(slideInfoMapper.listByApiId(1).size());
    }

    @Test
    public void insert() {
        SlideInfo slideInfo=new SlideInfo();
        slideInfo.setApiId(1);
        slideInfo.setImage("sdadadada");
        slideInfo.setSort(1);
        slideInfo.setSummary("sdadada");
        slideInfo.setThumbnail("dsacsa");
        slideInfo.setTitle("cscscs");
        slideInfo.setUrl("sadada");
        slideInfoMapper.insert(slideInfo);
    }

    @Test
    public void update() {
        SlideInfo slideInfo=new SlideInfo();
        slideInfo.setApiId(1);
        slideInfo.setImage("QQ");
        slideInfo.setSort(1);
        slideInfo.setSummary("QQ");
        slideInfo.setThumbnail("QQ");
        slideInfo.setTitle("QQ");
        slideInfo.setUrl("QQ");
        slideInfo.setId(2);
        slideInfoMapper.update(slideInfo);
    }

    @Test
    public void delete() {
        slideInfoMapper.delete(new Integer[]{3});
    }

    @Test
    public void mapListByApiId() {
        System.out.println(slideInfoMapper.mapListByApiId(1));
    }
}