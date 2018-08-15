package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.starInfo;

public interface starInfoMapper {
    int insert(starInfo record);

    int insertSelective(starInfo record);
}