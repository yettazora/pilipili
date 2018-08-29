package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.SeoInfo;

public interface SeoInfoMapper {

    /**
     * 根据类型，查询seo信息
     * @param type 类型
     * @return
     */
    SeoInfo selectByType(String type);

    /**
     * seo信息
     * @param seoInfo
     */
    int update(SeoInfo seoInfo);
}