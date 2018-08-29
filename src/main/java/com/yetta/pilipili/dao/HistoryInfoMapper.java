package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.HistoryInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HistoryInfoMapper {

    /**
     * 添加记录
     * @param historyInfo
     * @return
     */
    int insert(HistoryInfo historyInfo);

    /**
     * 删除记录
     * @param historyInfo
     * @return
     */
    int delete(HistoryInfo historyInfo);

    /**
     * 获取用户最新的5条历史记录
     * @param userId
     * @return
     */
    List<Map<String, Object>> listHistory5(Integer userId);

    /**
     * 获取用户的历史记录列表
     * @param userId
     * @return
     */
    List<Map<String, Object>> listHistory(Integer userId);

    /**
     * 删除历史浏览记录表中的内容
     * @param userIdArr 用户id数组
     * @return
     */
    int deleteByUserIdArr(@Param("userIdArr") Integer[] userIdArr);
}