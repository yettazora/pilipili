package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 标签表
 *
 * @author yetta
 */
public class TagInfo implements Serializable {

    private Integer id;     //主键

    private String name;    //标签名称

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
}