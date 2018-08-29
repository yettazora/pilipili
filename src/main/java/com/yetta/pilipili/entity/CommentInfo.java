package com.yetta.pilipili.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户对某个视频的评论表
 *
 * @author yetta
 */
public class CommentInfo implements Serializable {
    private Integer id;         //主键

    private Integer videoId;    //视频ID

    private Integer userId;     //用户ID

    private String content;     //评论内容

    private Date updateTime;    //评论时间

    private String loginName;   //用户登录名

    private String avatar;      //用户头像

    private List<ReplyInfo> replyInfoList;  //回复列表

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getAvatar(){
        return avatar;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public List<ReplyInfo> getReplyInfoList() {
        return replyInfoList;
    }

    public void setReplyInfoList(List<ReplyInfo> replyInfoList) {
        this.replyInfoList = replyInfoList;
    }
}