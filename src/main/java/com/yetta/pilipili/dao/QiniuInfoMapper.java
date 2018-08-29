package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.QiniuInfo;

public interface QiniuInfoMapper {

    /**
     * 查询指定类型的配置
     * @param type 类型
     * @return
     */
    QiniuInfo selectByType(String type);

    /**
     * 根据类型更新
     * @param qiniuInfo
     * @return
     */
    int update(QiniuInfo qiniuInfo);
}