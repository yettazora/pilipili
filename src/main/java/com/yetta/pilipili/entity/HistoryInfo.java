package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户历史播放记录
 *
 * @author yetta
 */

public class HistoryInfo implements Serializable {
    private Integer id;         //主键

    private Integer videoId;    //视频主键

    private Integer userId;     //用户ID主键

    private Date updateTime;    //浏览时间

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}