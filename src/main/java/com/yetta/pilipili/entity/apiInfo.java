package com.yetta.pilipili.entity;

import java.io.Serializable;

public class apiInfo implements Serializable {
    private Integer id;

    private String name;

    private Integer sort;

    private String type;

    private String leixing;

    private String diqu;

    private String nianfen;

    private String zhuangtai;

    private String zifei;

    private String xingqi;

    private String typeId;

    private String field;

    private Integer num;

    private String tag;

    private Integer selectVideo;

    private String kandian;

    private String zongjishu;

    private String shangyingnianfen;

    private String fengge;

    private String shengyou;

    private String rankType;

    private String cacheTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }

    public String getDiqu() {
        return diqu;
    }

    public void setDiqu(String diqu) {
        this.diqu = diqu == null ? null : diqu.trim();
    }

    public String getNianfen() {
        return nianfen;
    }

    public void setNianfen(String nianfen) {
        this.nianfen = nianfen == null ? null : nianfen.trim();
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai == null ? null : zhuangtai.trim();
    }

    public String getZifei() {
        return zifei;
    }

    public void setZifei(String zifei) {
        this.zifei = zifei == null ? null : zifei.trim();
    }

    public String getXingqi() {
        return xingqi;
    }

    public void setXingqi(String xingqi) {
        this.xingqi = xingqi == null ? null : xingqi.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getSelectVideo() {
        return selectVideo;
    }

    public void setSelectVideo(Integer selectVideo) {
        this.selectVideo = selectVideo;
    }

    public String getKandian() {
        return kandian;
    }

    public void setKandian(String kandian) {
        this.kandian = kandian == null ? null : kandian.trim();
    }

    public String getZongjishu() {
        return zongjishu;
    }

    public void setZongjishu(String zongjishu) {
        this.zongjishu = zongjishu == null ? null : zongjishu.trim();
    }

    public String getShangyingnianfen() {
        return shangyingnianfen;
    }

    public void setShangyingnianfen(String shangyingnianfen) {
        this.shangyingnianfen = shangyingnianfen == null ? null : shangyingnianfen.trim();
    }

    public String getFengge() {
        return fengge;
    }

    public void setFengge(String fengge) {
        this.fengge = fengge == null ? null : fengge.trim();
    }

    public String getShengyou() {
        return shengyou;
    }

    public void setShengyou(String shengyou) {
        this.shengyou = shengyou == null ? null : shengyou.trim();
    }

    public String getRankType() {
        return rankType;
    }

    public void setRankType(String rankType) {
        this.rankType = rankType == null ? null : rankType.trim();
    }

    public String getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(String cacheTime) {
        this.cacheTime = cacheTime == null ? null : cacheTime.trim();
    }
}