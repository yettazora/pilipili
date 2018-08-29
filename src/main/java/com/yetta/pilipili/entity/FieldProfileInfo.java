package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 字段简况表
 *
 * @author yetta
 */

public class FieldProfileInfo implements Serializable {
    private Integer id;         //主键

    private String name;        //字段内容名称(大陆,香港,欧美)

    private Integer sort;       //排序

    private Integer fieldId;    //字段的主键

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

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
}