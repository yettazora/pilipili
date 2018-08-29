package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.CommentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentInfoMapper {

    /**
     * 插入新的评论
     * @param commentInfo
     * @return
     */
    int insert(CommentInfo commentInfo);

    /**
     * 获取某个视频的评论列表
     * @param videoId 视频主键ID
     * @return
     */
    List<CommentInfo> listByVideoId(@Param("videoId") Integer videoId);

    /**
     * 获取某个视频下的评论数
     * @param videoId 视频主键ID
     * @return
     */
    int countByVideoId(@Param("videoId") Integer videoId);

    /**
     * 删除评论表中的内容
     * @param userIdArr 用户ID数组
     * @return
     */
    int deleteByUserIdArr(@Param("userIdArr") Integer userIdArr[]);
}