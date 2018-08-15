package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户认证激活表
 *
 * @author yetta
 */

public class ActivateInfo implements Serializable{

    private Integer id;         //主键

    private Integer userId;     //用户ID

    private String type;        //激活类型

    private String code;        //验证码

    private Date createTime;    //验证码生成时间

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}