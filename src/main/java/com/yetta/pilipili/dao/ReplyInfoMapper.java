package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.ReplyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyInfoMapper {

    /**
     * 插入新的回复
     * @param replyInfo
     * @return
     */
    int insert(ReplyInfo replyInfo);

    /**
     * 获取某个评论的回复列表
     * @param commentId 评论表主键
     * @return
     */
    List<ReplyInfo> listByCommentId(Integer commentId);

    /**
     * 获取某个视频的回复条数
     * @param videoId 视频主键
     * @return
     */
    int countByVideoId(Integer videoId);

    /**
     * 删除回复表中的内容
     * @param userIdArr 用户id数组
     * @return
     */
    int deleteByUserIdArr(@Param("userIdArr") Integer[] userIdArr);
}