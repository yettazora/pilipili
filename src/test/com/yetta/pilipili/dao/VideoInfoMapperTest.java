package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.VideoInfo;
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

public class VideoInfoMapperTest {

    VideoInfoMapper videoInfoMapper;

    @Before
    public void init(){
        String xml="spring-mybatis.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xml);
        SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        SqlSession session=sqlSessionFactory.openSession();
        videoInfoMapper=session.getMapper(VideoInfoMapper.class);
    }

    @Test
    public void listByMediaId() {
        List list=videoInfoMapper.listByMediaId(1);
        System.out.println(list.size());
        VideoInfo videoInfo= (VideoInfo) list.get(0);
        System.out.println(videoInfo.getUpdateTime());
    }

    @Test
    public void listByMediaIdDesc() {
        List list=videoInfoMapper.listByMediaIdDesc(1);
        System.out.println(list.size()+"   "+list);
    }

    @Test
    public void selectById() {
        VideoInfo videoInfo=videoInfoMapper.selectById(1);
        System.out.println(videoInfo.getUpdateTime()+"  "+videoInfo.getRemark()+"  "+videoInfo.getBiaoti());
    }

    @Test
    public void insert() {
        VideoInfo videoInfo=new VideoInfo();
        videoInfo.setBiaoti("aaaaaaaa");
        videoInfo.setImage("aaaaaaaa");
        videoInfo.setMediaId(1);
        videoInfo.setNum("aaaaaaaa");
        videoInfo.setPlay("aaaaaaaa");
        videoInfo.setPlayerId(1);
        videoInfo.setPower(123);
        videoInfo.setRemark("aaaaaaaa");
        videoInfo.setSort(233);
        videoInfo.setStatus(1);
        videoInfo.setTitle("aaaaaaaa");
        videoInfo.setUpdateTime(new Date());
        videoInfo.setUrl("aaaaaaaa");
        videoInfo.setVideoId(1);
        videoInfo.setViewCount(1234);
        videoInfo.setViewCountDay(12);
        videoInfo.setViewCountMonth(123);
        videoInfo.setViewCountWeek(122);
        videoInfo.setViewCountYear(12345);
        videoInfoMapper.insert(videoInfo);
        videoInfoMapper.insert(videoInfo);
        videoInfoMapper.insert(videoInfo);
        videoInfoMapper.insert(videoInfo);
    }

    @Test
    public void update() {
        VideoInfo videoInfo=new VideoInfo();
        videoInfo.setBiaoti("bbbbbbbb");
        videoInfo.setImage("bbbbbbbbb");
        videoInfo.setMediaId(1);
        videoInfo.setNum("bbbbbbbbb");
        videoInfo.setPlay("bbbbbbbbbb");
        videoInfo.setPlayerId(1);
        videoInfo.setPower(123);
        videoInfo.setRemark("bbbbbbbb");
        videoInfo.setSort(233);
        videoInfo.setStatus(1);
        videoInfo.setTitle("bbbbbbbbbb");
        videoInfo.setUpdateTime(new Date());
        videoInfo.setUrl("bbbbbbbbbbb");
        videoInfo.setVideoId(2);
        videoInfo.setViewCount(1);
        videoInfo.setViewCountDay(22);
        videoInfo.setViewCountMonth(333);
        videoInfo.setViewCountWeek(4444);
        videoInfo.setViewCountYear(55555);
        videoInfoMapper.update(videoInfo);
    }

    @Test
    public void selectByMediaIdFirst() {
        VideoInfo videoInfo=videoInfoMapper.selectByMediaIdFirst(1);
        System.out.println(videoInfo.getUpdateTime()+"  "+videoInfo.getVideoId());
    }

    @Test
    public void selectByMediaIdLast() {
        VideoInfo videoInfo=videoInfoMapper.selectByMediaIdLast(1);
        System.out.println(videoInfo.getUpdateTime()+"  "+videoInfo.getVideoId());
    }

    @Test
    public void countByPlayerId() {
        System.out.println(videoInfoMapper.countByPlayerId(1));
    }

    @Test
    public void updateImage() {
        videoInfoMapper.updateImage(1, "LOL");
    }

    @Test
    public void selectByMediaIdAndNum() {
        VideoInfo videoInfo=videoInfoMapper.selectByMediaIdAndNum(1, "12");
        System.out.println(videoInfo.getVideoId()+"  "+videoInfo.getPlayerId());
    }

    @Test
    public void batchUpdateStatus() {
        videoInfoMapper.batchUpdateStatus(new Integer[]{4,5,6}, 3);
    }

    @Test
    public void batchDelete() {
        videoInfoMapper.batchDelete(new Integer[]{4,5});
    }

    @Test
    public void selectVideoPlayById() {
        VideoInfo videoInfo=videoInfoMapper.selectVideoPlayById(6);
        System.out.println(videoInfo.getPlayerId()+"  "+videoInfo.getUrl());
    }

    @Test
    public void updatePower() {
        videoInfoMapper.updatePower(1, 999);
    }

    @Test
    public void listNewVideo() {
        List list=videoInfoMapper.listNewVideo(2);
        for (Object v :
                list) {
            VideoInfo videoInfo= (VideoInfo) v;
            System.out.println(videoInfo.getVideoId());
        }
    }

    @Test
    public void batchUpdate() {
        Map<String,Object> map=new HashMap<>();
        map.put("status", 404);
        map.put("mediaIdArr", new Integer[]{1,2,3,6});
        videoInfoMapper.batchUpdate(map);
    }

    @Test
    public void clearViewCount() {
        VideoInfo videoInfo=new VideoInfo();
        videoInfo.setViewCountMonth(0);
        videoInfo.setVideoId(2);
        videoInfoMapper.clearViewCount(videoInfo);
    }

    @Test
    public void selectByIdWithPortal() {
        VideoInfo videoInfo=new VideoInfo();
        videoInfo=videoInfoMapper.selectByIdWithPortal(1);
        System.out.println(videoInfo.getBiaoti()+"  "+videoInfo.getUrl()+"  "+videoInfo.getVideoId());
    }

    @Test
    public void batchDeleteByMediaId() {
        videoInfoMapper.batchDeleteByMediaId(new Integer[]{3,4});
    }
}