package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.GroupInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class GroupInfoMapperTest {

    GroupInfoMapper groupInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        groupInfoMapper=session.getMapper(GroupInfoMapper.class);
    }

    @Test
    public void list() {
        System.out.println(groupInfoMapper.list());
    }

    @Test
    public void insert() {
        GroupInfo groupInfo=new GroupInfo();
        groupInfo.setName("基佬");
        groupInfo.setPower(132);
        groupInfo.setSort(12);
        groupInfo.setType("user");
        groupInfoMapper.insert(groupInfo);
    }

    @Test
    public void update() {
        GroupInfo groupInfo=new GroupInfo();
        groupInfo.setName("有基佬拉开我裤链");
        groupInfo.setPower(233);
        groupInfo.setSort(21);
        groupInfo.setType("user");
        groupInfo.setId(3);
        groupInfoMapper.update(groupInfo);
    }

    @Test
    public void delete() {
        groupInfoMapper.delete(new Integer[]{4,5});
    }

    @Test
    public void selectPowerByUserId() {
//        返回值为空却赋值为int型就会报这个错:attempted to return null from a method with a primitive return type (int).
        int a=groupInfoMapper.selectPowerByUserId(3);
        System.out.println(a);
    }

    @Test
    public void countByName() {
        System.out.println(groupInfoMapper.countByName("基佬", 4));
    }
}