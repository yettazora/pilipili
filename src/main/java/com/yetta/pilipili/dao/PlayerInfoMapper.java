package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.PlayerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerInfoMapper {
    /**
     * 查询播放器列表
     */
    List<PlayerInfo> list();

    /**
     * 插入新的播放器
     * @param playerInfo
     * @return
     */
    int insert(PlayerInfo playerInfo);

    /**
     * 更新播放器
     * @param playerInfo
     * @return
     */
    int update(PlayerInfo playerInfo);

    /**
     * 批量删除播放器
     * @param idArr 主键数组
     * @return
     */
    int delete(@Param("idArr") Integer[] idArr);

    /**
     * 根据主键查询播放器信息
     * @param id 主键
     * @return
     */
    PlayerInfo selectById(Integer id);

    /**
     * 根据主键查询播放器内容
     * @param id 主键
     * @return
     */
    String selectContentById(Integer id);
}