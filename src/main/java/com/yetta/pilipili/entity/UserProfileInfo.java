package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 用户个人信息简况表
 *
 * @author yetta
 */
public class UserProfileInfo implements Serializable {

    private Integer id;             //主键

    private Integer userId;         //用户ID主键

    private Integer groupId;        //用户组ID

    private String avatar;          //用户头像图片地址

    private String signPersonal;    //用户个性签名

    private Integer point;          //用户积分

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