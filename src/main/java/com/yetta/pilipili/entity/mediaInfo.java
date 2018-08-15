package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

public class mediaInfo implements Serializable {
    private Integer mediaId;

    private Date updateTime;

    private Integer status;

    private String haibao;

    private String fengmian;

    private String biaoti;

    private String kandian;

    private String jianjie;

    private String tag;

    private String zongjishu;

    private String bieming;

    private Integer typeId;

    private String dafengmian;

    private Integer hasVideo;

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

    public String getKandian() {
        return kandian;
    }

    public void setKandian(String kandian) {
        this.kandian = kandian == null ? null : kandian.trim();
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

    public String getZongjishu() {
        return zongjishu;
    }

    public void setZongjishu(String zongjishu) {
        this.zongjishu = zongjishu == null ? null : zongjishu.trim();
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