package com.yetta.pilipili.entity;

import java.io.Serializable;

public class userProfileInfo implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer groupId;

    private String avatar;

    private String signPersonal;

    private Integer point;

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSignPersonal() {
        return signPersonal;
    }

    public void setSignPersonal(String signPersonal) {
        this.signPersonal = signPersonal == null ? null : signPersonal.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}