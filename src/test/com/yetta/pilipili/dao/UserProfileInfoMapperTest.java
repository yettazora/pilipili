package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.UserProfileInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserProfileInfoMapperTest {

    UserProfileInfoMapper userProfileInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        userProfileInfoMapper=session.getMapper(UserProfileInfoMapper.class);
    }

    @Test
    public void insert() {
        UserProfileInfo userProfileInfo=new UserProfileInfo();
        userProfileInfo.setAvatar("dsada");
        userProfileInfo.setGroupId(1);
        userProfileInfo.setPoint(1);
        userProfileInfo.setSignPersonal("dsada");
        userProfileInfo.setUserId(1);
        userProfileInfoMapper.insert(userProfileInfo);
    }

    @Test
    public void countByGroupId() {
        System.out.println(userProfileInfoMapper.countByGroupId(1));
    }

    @Test
    public void update() {
        UserProfileInfo userProfileInfo=new UserProfileInfo();
        userProfileInfo.setAvatar("QvQ");
        userProfileInfo.setGroupId(1);
        userProfileInfo.setPoint(1);
        userProfileInfo.setSignPersonal("QvQ");
        userProfileInfo.setUserId(3);
        userProfileInfo.setId(2);
        userProfileInfoMapper.update(userProfileInfo);
    }

    @Test
    public void batchUpdate() {
        Map<String,Object> map=new HashMap<>();
        map.put("groupId", 111);
        map.put("userIdArr", new Integer[]{1,3});
        userProfileInfoMapper.batchUpdate(map);
    }

}