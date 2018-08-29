package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.NavInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NavInfoMapper {

    /**
     * 查询导航列表
     */
    List<NavInfo> list();

    /**
     * 插入新的导航
     * @param navInfo
     * @return
     */
    int insert(NavInfo navInfo);

    /**
     * 更新导航
     * @param navInfo
     * @return
     */
    int update(NavInfo navInfo);

    /**
     * 批量删除导航
     * @param idArr 主键数组
     * @return
     */
    int delete(@Param("idArr") Integer[] idArr);

    /**
     * 根据频道主键删除导航
     * @param channelId
     */
    int deleteByChannelId(Integer channelId);

    /**
     * 可用导航列表
     * @return
     */
    List<NavInfo> listIsUse();

    /**
     * 频道编辑时，同步更新导航
     * @param navInfo
     */
    int updateByChannel(NavInfo navInfo);
}