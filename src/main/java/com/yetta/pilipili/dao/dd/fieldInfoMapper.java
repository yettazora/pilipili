package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.fieldInfo;

public interface fieldInfoMapper {
    int insert(fieldInfo record);

    int insertSelective(fieldInfo record);
}