package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.ApiInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ApiInfoMapperTest {

    ApiInfoMapper apiInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        apiInfoMapper=session.getMapper(ApiInfoMapper.class);
    }

    @Test
    public void listByType() {
        List<ApiInfo> list=apiInfoMapper.listByType("dianying");
        System.out.println(list);
    }

    @Test
    public void insert() {
        ApiInfo apiInfo=new ApiInfo();
        apiInfo.setSort(3);
        apiInfo.setName("zsan");
        apiInfo.setType("dianying");
        apiInfoMapper.insert(apiInfo);
    }

    @Test
    public void update() {
        ApiInfo apiInfo=new ApiInfo();
        apiInfo.setId(2);
        apiInfo.setSort(100);
        apiInfo.setName("lisi");
        apiInfo.setType("dianshiju");
        apiInfoMapper.update(apiInfo);
    }

    @Test
    public void delete() {
        Integer idArr[]=new Integer[]{7};
        apiInfoMapper.delete(idArr);
    }

    @Test
    public void selectById() {
        System.out.println(apiInfoMapper.selectById(1));
    }

    @Test
    public void countByField() {
        System.out.println(apiInfoMapper.countByField("num"));
    }

    @Test
    public void alter() {
        apiInfoMapper.alter("insert into api_info values(null,'asas',2,'sasa','22','dsdss',10,null,null,null,null)");
    }

    @Test
    public void updateRankSet() {
        ApiInfo apiInfo=new ApiInfo();
        apiInfo.setTypeId("22222");
        apiInfo.setRankType("dnsaon");
        apiInfo.setNum(333);
        apiInfo.setSelectVideo(88);
        apiInfo.setCacheTime("amdsodmao");
        apiInfo.setId(6);
        apiInfoMapper.updateRankSet(apiInfo);
    }
}