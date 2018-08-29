package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.MediaInfoMapper;
import com.yetta.pilipili.dao.PlayerInfoMapper;
import com.yetta.pilipili.dao.VideoInfoMapper;
import com.yetta.pilipili.entity.MediaInfo;
import com.yetta.pilipili.entity.VideoInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.VideoInfoService;
import com.yetta.pilipili.util.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service("videoInfoService")
public class VideoInfoServiceImpl implements VideoInfoService {

    @Autowired
    VideoInfoMapper videoInfoMapper;

    @Autowired
    PlayerInfoMapper playerInfoMapper;

    @Autowired
    MediaInfoMapper mediaInfoMapper;

    @Override
    public VideoInfo selectByIdWithPortal(Integer videoId) {
        //获取视频信息,前台页面播放专用
        VideoInfo videoInfo=videoInfoMapper.selectByIdWithPortal(videoId);

        if (videoInfo!=null){

            //播放量自增
            int nViewCount=videoInfo.getViewCount();
            nViewCount++;

            //日播放量自增
            int nViewCountDay=videoInfo.getViewCountDay();
            nViewCountDay++;

            //周播放量自增
            int nViewCountWeek=videoInfo.getViewCountWeek();
            nViewCountWeek++;

            //月播放量自增
            int nViewCountMonth=videoInfo.getViewCountMonth();
            nViewCountMonth++;

            //年播放量自增
            int nViewYear=videoInfo.getViewCountYear();
            nViewYear++;

            VideoInfo videoInfo2=new VideoInfo();
            videoInfo2.setVideoId(videoInfo.getVideoId());
            videoInfo2.setViewCount(nViewCount);
            videoInfo2.setViewCountDay(nViewCountDay);
            videoInfo2.setViewCountWeek(nViewCountWeek);
            videoInfo2.setViewCountMonth(nViewCountMonth);
            videoInfo2.setViewCountYear(nViewYear);

            videoInfoMapper.update(videoInfo2);
        }
        return videoInfo;
    }

    /**
     * 根据视频主键查询视频播放源(pc端)
     * @param videoId
     * @return
     */
    @Override
    public String selectVideoPlayById(Integer videoId) {

        //1. 获取视频信息
        VideoInfo videoInfo=videoInfoMapper.selectVideoPlayById(videoId);

        //2. 获取播放器配置参数
        String content=playerInfoMapper.selectContentById(videoInfo.getPlayerId());

        //3. 判断视频地址是否存在
        if (StringUtils.isEmpty(content)){
            content="";
        }else {
            if (StringUtils.isEmpty(videoInfo.getUrl())){
                //不存在时,不返回播放内容
                content="";
            }
            else {
               //存在时,替换播放器配置中的变量
                content=content.replace("{url}", videoInfo.getUrl());
            }
        }

        return content;
    }


    @Override
    public List<VideoInfo> listByMediaId(Integer mediaId) {
        return videoInfoMapper.listByMediaId(mediaId);
    }

    /**
     * 根据媒体信息主键，查询该视频下的所有播放集数，从大到小排序（后台管理专用）
     * @param mediaId 媒体信息主键
     * @return
     */
    public List<VideoInfo> listByMediaIdDesc(Integer mediaId) {
        return videoInfoMapper.listByMediaIdDesc(mediaId);
    }

    /**
     * 根据主键查询视频信息
     * @param videoId 主键
     * @return
     */
    public VideoInfo selectById(Integer videoId) {
        return videoInfoMapper.selectById(videoId);
    }

    /**
     * 视频播放地址保存
     * @param videoInfo
     */
    public void save(VideoInfo videoInfo) {
        Date currentTime = new Date();


        // 1.0 如果排序次数没填的话，则默认为1
        if (StringUtils.isEmpty(videoInfo.getSort())) {
            videoInfo.setSort(1);
        }

        // 2.0 如果播放总量没填的话，则默认为1
        if (StringUtils.isEmpty(videoInfo.getViewCount())) {
            videoInfo.setViewCount(1);
        }

        // 3.0 保存视频信息
        // 判断是新增还是更新
        if (StringUtils.isEmpty(videoInfo.getVideoId())) {
            // 新增
            videoInfo.setStatus(1);
            videoInfo.setUpdateTime(currentTime);
            videoInfo.setViewCountDay(0);
            videoInfo.setViewCountWeek(0);
            videoInfo.setViewCountMonth(0);
            videoInfo.setViewCountYear(0);
            videoInfoMapper.insert(videoInfo);
        } else {
            // 更新
            videoInfoMapper.update(videoInfo);
        }

        // 4.0 更新对应的媒体的时间、状态等
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.setMediaId(videoInfo.getMediaId());
        mediaInfo.setUpdateTime(currentTime);
        mediaInfo.setHasVideo(1);

        mediaInfoMapper.updateMedia(mediaInfo);
    }

    /**
     * 更新统一权限值
     * @param mediaId
     * @param power
     */
    public void updatePower(Integer mediaId, Integer power) {
        videoInfoMapper.updatePower(mediaId, power);
    }


    /**
     * 批量更新排序
     * @param videoIdArr 主键数组
     * @param sortArr 排序数组
     */
    public void updateSort(Integer[] videoIdArr, Integer[] sortArr) {
        for (int i=0; i<videoIdArr.length; i++) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoId(videoIdArr[i]);
            videoInfo.setSort(sortArr[i]);

            videoInfoMapper.update(videoInfo);
        }
    }


    /**
     * 批量更新视频状态
     * @param videoIdArr 主键数组
     * @param status 状态
     */
    public void batchUpdateStatus(Integer[] videoIdArr, Integer status) {
        videoInfoMapper.batchUpdateStatus(videoIdArr, status);
    }

    /**
     * 批量删除视频
     * @param videoIdArr 主键数组
     * @throws SystemException
     */
    public void batchDelete(Integer[] videoIdArr) throws SystemException {
        for (int i=0; i<videoIdArr.length; i++) {
            // 只有已经禁用的视频才可以被删除
            VideoInfo videoInfo = videoInfoMapper.selectById(videoIdArr[i]);
            if ("1".equals(videoInfo.getStatus())) {
                throw new SystemException(ErrorMsg.ERROR_600005);
            }
        }
        videoInfoMapper.batchDelete(videoIdArr);
    }

    /**
     * 更新统一封面
     * @param mediaId 媒体信息主键
     * @param image 图片地址
     */
    public void updateImage(Integer mediaId, String image) {
        videoInfoMapper.updateImage(mediaId, image);
    }

}
