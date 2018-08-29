package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 视频收藏表
 *
 * @author yetta
 */
public class CollectionInfo implements Serializable {
    private Integer id;         //主键

    private Integer mediaId;    //媒体表主键

    private Integer userId;     //用户ID

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}