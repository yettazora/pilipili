package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 媒体信息表
 *
 * @author yetta
 */

public class MediaInfo implements Serializable {

    private Integer mediaId;        //媒体信息主键

    private Date updateTime;        //更新时间

    private Integer status;         //状态,是否已删除至回收站.1代表正常

    private String haibao;          //海报

    private String fengmian;        //小封面

    private String biaoti;          //标题

    private String jianjie;         //简介

    private String tag;             //标签

    private String bieming;         //别名

    private Integer typeId;         //所属分类

    private String dafengmian;      //大封面

    private Integer hasVideo;       //判断改媒体下是否有视频,1:有,0:没有

    private static final long serialVersionUID = 1L;

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHaibao() {
        return haibao;
    }

    public void setHaibao(String haibao) {
        this.haibao = haibao == null ? null : haibao.trim();
    }

    public String getFengmian() {
        return fengmian;
    }

    public void setFengmian(String fengmian) {
        this.fengmian = fengmian == null ? null : fengmian.trim();
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }


    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie == null ? null : jianjie.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }


    public String getBieming() {
        return bieming;
    }

    public void setBieming(String bieming) {
        this.bieming = bieming == null ? null : bieming.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDafengmian() {
        return dafengmian;
    }

    public void setDafengmian(String dafengmian) {
        this.dafengmian = dafengmian == null ? null : dafengmian.trim();
    }

    public Integer getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Integer hasVideo) {
        this.hasVideo = hasVideo;
    }
}