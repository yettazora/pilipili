package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private Integer id;             //主键

    private String loginName;       //登录名

    private String passWord;        //登录密码

    private String email;           //注册邮箱

    private Date registerTime;      //注册时间

    private String registerIp;      //注册IP

    private Date lastLoginTime;     //上一次登录时间

    private String lastLoginIp;     //上一次登录IP

    private String status;         //用户状态(0:未激活,1:正常,2:封禁)

    private String avatar;          //用户头像

    private String signPersonal;    //用户个性签名

    private Integer point;          //用户积分

    private Integer groupId;        //用户所在组ID

    private String groupName;       //用户所在组名

    private Integer power;          //用户权限值

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp == null ? null : registerIp.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}