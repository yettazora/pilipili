package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

public class videoInfo implements Serializable {
    private Integer videoId;

    private Integer mediaId;

    private String num;

    private String title;

    private String image;

    private String url;

    private Integer viewCount;

    private Integer playerId;

    private Integer sort;

    private Integer status;

    private String remark;

    private Integer power;

    private Integer point;

    private Date updateTime;

    private Integer viewCountDay;

    private Integer viewCountWeek;

    private Integer viewCountMonth;

    private Integer viewCountYear;

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

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
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
}