package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 分类表
 *
 * @author yetta
 */
public class TypeInfo implements Serializable {

    private Integer id;                 //主键

    private String name;                //分类名称(电影,动漫,电视剧...)

    private Integer sort;               //排序

    private String profileTemplate;     //详情页模板

    private String playTemplate;        //播放页模板

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

    public String getProfileTemplate() {
        return profileTemplate;
    }

    public void setProfileTemplate(String profileTemplate) {
        this.profileTemplate = profileTemplate == null ? null : profileTemplate.trim();
    }

    public String getPlayTemplate() {
        return playTemplate;
    }

    public void setPlayTemplate(String playTemplate) {
        this.playTemplate = playTemplate == null ? null : playTemplate.trim();
    }
}