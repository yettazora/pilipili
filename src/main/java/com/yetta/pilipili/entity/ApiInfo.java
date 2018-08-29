package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 接口设置类
 *
 * @author yetta
 */

public class ApiInfo implements Serializable {
    private Integer id;             //主键

    private String name;            //名称,用于让用户识别自己的接口

    private Integer sort;           //排序

    private String type;            //接口类型(方便管理)

    private String typeId;          //接口来源于哪个分类

    private String field;           //该接口定义了哪些字段

    private Integer num;            //返回多少条数据

    private String tag;             //该接口定义了哪些书签

    private Integer selectVideo;    //是否查询该媒体下的视频信息(0:不查询 1:第1集 2:最新一集)

    private String rankType;        //排行榜类型(day:日榜 week:周邦 month:月榜 year:年榜)

    private String cacheTime;       //缓存时间

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