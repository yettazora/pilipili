package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.PlayerInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PlayerInfoMapperTest {

    PlayerInfoMapper playerInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        playerInfoMapper=session.getMapper(PlayerInfoMapper.class);
    }

    @Test
    public void list() {
        System.out.println(playerInfoMapper.list());
        PlayerInfo playerInfo=playerInfoMapper.list().get(2);
        System.out.println(playerInfo.getContent()+"  "+playerInfo.getName()+"  "+playerInfo.getSort());
    }

    @Test
    public void insert() {
        PlayerInfo playerInfo=new PlayerInfo();
        playerInfo.setContent("amsocnasocnoasc");
        playerInfo.setName("amsocnasocnoasc");
        playerInfo.setSort(233);
        playerInfoMapper.insert(playerInfo);
    }

    @Test
    public void update() {
        PlayerInfo playerInfo=new PlayerInfo();
        playerInfo.setContent("vasoivaiosnva");
        playerInfo.setName("mosanopcna");
        playerInfo.setSort(123);
        playerInfo.setId(3);
        playerInfoMapper.update(playerInfo);
    }

    @Test
    public void delete() {
        playerInfoMapper.delete(new Integer[]{1,2});
    }

    @Test
    public void selectById() {
        PlayerInfo playerInfo=playerInfoMapper.selectById(3);
        System.out.println(playerInfo.getContent()+"  "+playerInfo.getName()+"  "+playerInfo.getSort());
    }

    @Test
    public void selectContentById() {
        System.out.println(playerInfoMapper.selectContentById(3));
    }
}