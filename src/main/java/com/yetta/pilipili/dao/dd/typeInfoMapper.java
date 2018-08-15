package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.typeInfo;

public interface typeInfoMapper {
    int insert(typeInfo record);

    int insertSelective(typeInfo record);
}