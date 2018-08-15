package com.yetta.pilipili.entity;

import java.io.Serializable;

public class typeField implements Serializable {
    private Integer id;

    private Integer typeId;

    private Integer fieldId;

    private Integer isScreen;

    private Integer sort;

    private Integer isRequired;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getIsScreen() {
        return isScreen;
    }

    public void setIsScreen(Integer isScreen) {
        this.isScreen = isScreen;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }
}