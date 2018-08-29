package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.MediaInfo;
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

public class MediaInfoMapperTest {

    MediaInfoMapper mediaInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        mediaInfoMapper=session.getMapper(MediaInfoMapper.class);
    }

    @Test
    public void list() {
        Map<String,Object> map=new HashMap<>();
        map.put("typeId", 1);
        map.put("status", 11);
        map.put("keyword", "dq");
        List list=mediaInfoMapper.list(map);
        MediaInfo mediaInfo= (MediaInfo) list.get(0);

        System.out.println(mediaInfo.getMediaId()+"  "+mediaInfo.getTypeId());
    }

    @Test
    public void insert() {
        MediaInfo mediaInfo=new MediaInfo();
        mediaInfo.setBiaoti("dadasdad");
        mediaInfo.setBieming("assadasd");
        mediaInfo.setDafengmian("saascasca");
        mediaInfo.setFengmian("cscdsvdsv");
        mediaInfo.setHaibao("sdmvmdkvmsvmdolsd");
        mediaInfo.setHasVideo(1);
        mediaInfo.setJianjie("scacsaca");
        mediaInfo.setMediaId(1);
        mediaInfo.setStatus(1);
        mediaInfo.setTag("dadasdad");
        mediaInfo.setTypeId(1);
        mediaInfo.setUpdateTime(new Date());
        mediaInfoMapper.insert("insert into media_info(update_time,status,type_id) values('2018-08-16 10:37:12',1,1)");
    }

    @Test
    public void update() {
        mediaInfoMapper.update("update media_info set update_time='2018-08-16 10:37:12',status=2,type_id=100 where media_id=3");
    }

    @Test
    public void selectById() {
        MediaInfo mediaInfo=mediaInfoMapper.selectById(1);
        System.out.println(mediaInfo.getBiaoti()+mediaInfo.getBieming()+mediaInfo.getHasVideo());
    }

    @Test
    public void selectBiaotiById() {
        System.out.println(mediaInfoMapper.selectBiaotiById(1));
    }

    @Test
    public void selectByMediaId() {
        System.out.println(mediaInfoMapper.selectByMediaId(1));
    }

    @Test
    public void searchIdByKeyWord() {
        System.out.println(mediaInfoMapper.searchIdByKeyWord("dq"));
    }

    @Test
    public void listByFilter() {
        System.out.println(mediaInfoMapper.listByFilter("select * from media_info where media_id =1"));
    }

    @Test
    public void updateMedia() {
        MediaInfo mediaInfo=new MediaInfo();
        mediaInfo.setBiaoti("dadasdad");
        mediaInfo.setBieming("assadasd");
        mediaInfo.setDafengmian("saascasca");
        mediaInfo.setFengmian("cscdsvdsv");
        mediaInfo.setHaibao("sdmvmdkvmsvmdolsd");
        mediaInfo.setHasVideo(100);
        mediaInfo.setJianjie("scacsaca");
        mediaInfo.setMediaId(1);
        mediaInfo.setStatus(1);
        mediaInfo.setTag("dadasdad");
        mediaInfo.setTypeId(1);
        mediaInfo.setUpdateTime(new Date());
        mediaInfo.setMediaId(3);
        mediaInfoMapper.updateMedia(mediaInfo);
    }

    @Test
    public void countByBiaoti() {
        System.out.println(mediaInfoMapper.countByBiaoti("nscansoandq", 1));
    }

    @Test
    public void batchUpdate() {
        Map<String,Object> map=new HashMap<>();
        map.put("status", 404);
        map.put("typeId", 233);
        map.put("mediaIdArr", new Integer[]{2,3});
        mediaInfoMapper.batchUpdate(map);
    }

    @Test
    public void alter() {
        mediaInfoMapper.insert("insert into media_info(update_time,status,type_id) values('2018-08-16 10:37:12',1,1)");
    }

    @Test
    public void selectSqlById() {
        MediaInfo mediaInfo=mediaInfoMapper.selectById(1);
        System.out.println(mediaInfo.getBiaoti()+"  "+mediaInfo.getDafengmian());
    }

    @Test
    public void selectSqlByApi() {
        System.out.println(mediaInfoMapper.selectSqlByApi("select biaoti from media_info where media_id=1"));
    }

    @Test
    public void batchDelete() {
        mediaInfoMapper.batchDelete(new Integer[]{3});
    }
}