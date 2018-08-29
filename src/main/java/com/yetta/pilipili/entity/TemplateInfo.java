package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 模板配置表
 *
 * @author yetta
 */
public class TemplateInfo implements Serializable {

    private Integer id;     //主键

    private String type;    //类型(pc:电脑端,吗:手机端)

    private String name;    //模板的名称

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}