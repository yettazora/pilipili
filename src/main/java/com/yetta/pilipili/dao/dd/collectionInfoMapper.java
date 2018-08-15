package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.collectionInfo;

public interface collectionInfoMapper {
    int insert(collectionInfo record);

    int insertSelective(collectionInfo record);
}