package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频播放地址表
 *
 * @author yetta
 */
public class VideoInfo implements Serializable {

    private Integer videoId;        //主键

    private Integer mediaId;        //媒体信息主键

    private String num;             //第几集

    private String title;           //该集标题

    private String image;           //该集封面

    private String url;             //视频播放地址

    private Integer viewCount;      //视频总播放量

    private Integer playerId;       //播放器ID

    private Integer sort;           //排序用

    private Integer status;         //状态,是否禁用,1:代表正常,0:代表禁用

    private String remark;          //视频简介

    private Integer power;          //视频播放权限值

    private String biaoti;          //媒体信息名称

    private Date updateTime;        //发布时间

    private Integer viewCountDay;   //日播放量

    private Integer viewCountWeek;  //周播放量

    private Integer viewCountMonth; //月播放量

    private Integer viewCountYear;  //年播放量

    private String play;            //播放内容

    private static final long serialVersionUID = 1L;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViewCountDay() {
        return viewCountDay;
    }

    public void setViewCountDay(Integer viewCountDay) {
        this.viewCountDay = viewCountDay;
    }

    public Integer getViewCountWeek() {
        return viewCountWeek;
    }

    public void setViewCountWeek(Integer viewCountWeek) {
        this.viewCountWeek = viewCountWeek;
    }

    public Integer getViewCountMonth() {
        return viewCountMonth;
    }

    public void setViewCountMonth(Integer viewCountMonth) {
        this.viewCountMonth = viewCountMonth;
    }

    public Integer getViewCountYear() {
        return viewCountYear;
    }

    public void setViewCountYear(Integer viewCountYear) {
        this.viewCountYear = viewCountYear;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play == null ? null : play.trim();
    }
}