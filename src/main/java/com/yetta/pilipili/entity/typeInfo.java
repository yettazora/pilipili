package com.yetta.pilipili.entity;

import java.io.Serializable;

public class typeInfo implements Serializable {
    private Integer id;

    private String name;

    private Integer sort;

    private String profileTemplate;

    private String playTemplate;

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