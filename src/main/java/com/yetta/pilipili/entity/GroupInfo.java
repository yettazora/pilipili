package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 用户组表
 *
 * @author yetta
 */
public class GroupInfo implements Serializable {
    private Integer id;         //主键

    private String name;        //用户组名称

    private Integer power;      //用户组权限值,管理员最大255

    private String type;        //该用户组是否为系统内置,system代表系统内置,不可修改

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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
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
}