package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserInfoMapperTest {

    UserInfoMapper userInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        userInfoMapper=session.getMapper(UserInfoMapper.class);
    }

    @Test
    public void selectUser() {
        UserInfo userInfo=userInfoMapper.selectUser("aaaaaaaaa", "aaaaaaaaa");
        System.out.println(userInfo.getAvatar()+"  "+userInfo.getRegisterIp());
    }

    @Test
    public void countUser() {
        System.out.println(userInfoMapper.countUser("aaaaaaaaa", "aaaaaaaaa"));
    }

    @Test
    public void insert() {
        UserInfo userInfo=new UserInfo();
        userInfo.setEmail("aaaaaaaaa");
        userInfo.setLastLoginIp("aaaaaaaaa");
        userInfo.setLastLoginTime(new Date());
        userInfo.setLoginName("aaaaaaaaa");
        userInfo.setPassWord("aaaaaaaaa");
        userInfo.setRegisterIp("aaaaaaaaa");
        userInfo.setRegisterTime(new Date());
        userInfo.setStatus("0");
        userInfo.setAvatar("aaaaaaaaa");
        userInfo.setGroupId(1);
        userInfo.setPoint(1);
        userInfo.setPower(123);
        userInfo.setSignPersonal("aaaaaaaaa");
        userInfo.setGroupName("aaaaaaaaa");
        System.out.println(userInfo.getStatus());
//        System.out.println(userInfoMapper.insert(userInfo));
        System.out.println(userInfo.getId());
    }

    @Test
    public void selectUserById() {
        UserInfo userInfo=userInfoMapper.selectUserById(3);
        System.out.println(userInfo.getAvatar()+"  "+userInfo.getEmail());
    }

    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("groupId", 3);
        map.put("keyWord", "aa");
        List<UserInfo> userInfo=userInfoMapper.list(map);
        UserInfo userInfo1=userInfo.get(0);
        System.out.println(userInfo1.getAvatar());
    }

    @Test
    public void batchUpdate() {
        Map<String,Object> map=new HashMap<>();
        map.put("status", 0);
        map.put("idArr", new Integer[]{3,4,5,6});
        userInfoMapper.batchUpdate(map);
    }

    @Test
    public void update() {
        UserInfo userInfo=new UserInfo();
        userInfo.setEmail("bbbbbbbbbb");
        userInfo.setLastLoginIp("bbbbbbbbbb");
        userInfo.setLastLoginTime(new Date());
        userInfo.setLoginName("bbbbbbbbbbb");
        userInfo.setPassWord("bbbbbbbbbbb");
        userInfo.setRegisterIp("bbbbbbbbbbb");
        userInfo.setRegisterTime(new Date());
        userInfo.setStatus("0");
        userInfo.setAvatar("bbbbbbbbb");
        userInfo.setGroupId(1);
        userInfo.setPoint(1);
        userInfo.setPower(123);
        userInfo.setSignPersonal("bbbbbbbbbbb");
        userInfo.setGroupName("bbbbbbbbbb");
        userInfo.setId(2);
        userInfoMapper.update(userInfo);
    }

    @Test
    public void countByEmail() {
        System.out.println(userInfoMapper.countByEmail("aaaaaaaaa"));
    }

    @Test
    public void selectUserByEmail() {
        UserInfo userInfo=userInfoMapper.selectUserByEmail("aaaaaaaaa");
        System.out.println(userInfo.getId()+"  "+userInfo.getLoginName()+"  "+userInfo.getEmail());
    }

    @Test
    public void selectById() {
        UserInfo userInfo=new UserInfo();
        userInfo=userInfoMapper.selectById(3);
        System.out.println(userInfo.getLoginName()+"  "+userInfo.getPassWord()+"  "+userInfo.getAvatar()+"  "+userInfo.getPoint());

    }
}