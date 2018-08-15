package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.qiniuInfo;

public interface qiniuInfoMapper {
    int insert(qiniuInfo record);

    int insertSelective(qiniuInfo record);
}