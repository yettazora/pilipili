package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 对某条评论或回复的回复表
 *
 * @author yetta
 */
public class ReplyInfo implements Serializable {

    private Integer id;             //主键

    private Integer commentId;      //评论表的ID主键

    private Integer userId;         //用户ID主键

    private String loginName;       //hui回复人的登录名

    private Integer toUserId;       //被回复人的ID

    private String toLoginName;     //被回复人的登录名

    private Date updateTime;        //回复时间

    private String content;         //回复内容

    private Integer videoId;        //视频ID主键

    private String avatar;          //用户头像

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getToLoginName() {
        return toLoginName;
    }

    public void setToLoginName(String toLoginName) {
        this.toLoginName = toLoginName == null ? null : toLoginName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}