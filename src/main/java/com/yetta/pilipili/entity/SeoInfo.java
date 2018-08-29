package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * SEO Search Engine Optimization缩写而来,中文意译为“搜索引擎优化”。
 *
 * @author yetta
 */

public class SeoInfo implements Serializable {

    private Integer id;             //主键

    private String title;           //标题

    private String keywords;        //关键字

    private String description;     //描述

    private String type;            //类型(播放页,首页...)

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}