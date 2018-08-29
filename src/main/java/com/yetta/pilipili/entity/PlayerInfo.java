package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 播放器接口表
 *
 * @author yetta
 */
public class PlayerInfo implements Serializable {

    private Integer id;         //主键

    private String name;        //名称

    private String content;     //播放器内容

    private Integer sort;       //排序

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}