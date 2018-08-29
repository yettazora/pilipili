package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 导航表
 *
 * @author yetta
 */
public class NavInfo implements Serializable {

    private Integer id;         //主键

    private String name;        //导航名称

    private String link;        //导航链接

    private String type;        //导航类型(system:系统内置,user:用户自定义)

    private Integer sort;       //排序

    private Integer isIndex;    //是否首页

    private Integer isUse;      //是否可用

    private Integer channelId;  //频道主键

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsIndex() {
        return isIndex;
    }

    public void setIsIndex(Integer isIndex) {
        this.isIndex = isIndex;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
}