package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.ChannelInfo;

import java.util.List;

public interface ChannelInfoMapper {

    /**
     * 查询频道栏目列表
     * @return
     */
    List<ChannelInfo> list();

    /**
     * 插入新的频道栏目
     * @param channelInfo
     * @return
     */
    int insert(ChannelInfo channelInfo);

    /**
     * 更新频道栏目
     * @param channelInfo
     * @return
     */
    int update(ChannelInfo channelInfo);

    /**
     * 根据主键查询信息
     * @param id
     * @return
     */
    ChannelInfo selectById(Integer id);

    /**
     * 根据id删除频道
     * @param id
     * @return
     */
    int delete(Integer id);
}