package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.WebInfo;

public interface WebInfoMapper {

    /**
     * 查询网站信息
     * @return
     */
    WebInfo select();

    /**
     * 保存站点信息配置
     * @param webInfo
     */
    int update(WebInfo webInfo);
}