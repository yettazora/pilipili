package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 分类信息字段配置表,某个分类信息中包含哪些字段
 *
 * @author yetta
 */
public class TypeField implements Serializable {

    private Integer id;         //主键

    private Integer typeId;     //分类信息ID主键

    private Integer fieldId;    //字段ID主键

    private Integer isScreen;   //该字段是否允许在列表页进行筛选(1:允许,0:禁止)

    private Integer sort;       //排序

    private Integer isRequired; //该字段在编辑页面是否为必填(1:必填,0:不必填)

    private String fieldName;   //字段名称

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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }
}