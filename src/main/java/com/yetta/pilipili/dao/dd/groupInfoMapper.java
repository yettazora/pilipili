package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.groupInfo;

public interface groupInfoMapper {
    int insert(groupInfo record);

    int insertSelective(groupInfo record);
}