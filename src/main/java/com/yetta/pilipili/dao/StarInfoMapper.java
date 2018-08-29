package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.StarInfo;

import java.util.List;

public interface StarInfoMapper {

    /**
     * 查询明星列表
     */
    List<StarInfo> list();

    /**
     * 查询单个明星的信息
     * @param id
     * @return
     */
    StarInfo selectById(Integer id);

    /**
     * 插入一条明星数据
     * @param starInfo
     */
    int insert(StarInfo starInfo);

    /**
     * 更新一条明星数据
     * @param starInfo
     */
    int update(StarInfo starInfo);
}