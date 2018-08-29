package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 字段信息表
 *
 * @author yetta
 */

public class FieldInfo implements Serializable {
    private Integer id;             //主键

    private String name;            //分类名称,视频所属分类(电影,电视剧,动漫...)

    private Integer sort;           //排序

    private String inputType;       //填写类型

    private String varName;         //变量名

    private String type;            //改用户组是否为系统内置(system代表系统内置,不可修改)

    private Integer isAllowEdit;    //该字段是否允许编辑,1:有详情,允许编辑

    private String content;         //字段模板

    private String isSelected;      //判断在指定分类中是否包含指定字段(1:包含)

    private List<FieldProfileInfo> fieldProfileInfoList;        //字段详情

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

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType == null ? null : inputType.trim();
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName == null ? null : varName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIsAllowEdit() {
        return isAllowEdit;
    }

    public void setIsAllowEdit(Integer isAllowEdit) {
        this.isAllowEdit = isAllowEdit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected== null ? null : isSelected.trim();
    }

    public List<FieldProfileInfo> getFieldProfileInfoList() {
        return fieldProfileInfoList;
    }

    public void setFieldProfileInfoList(List<FieldProfileInfo> fieldProfileInfoList) {
        this.fieldProfileInfoList = fieldProfileInfoList;
    }
}