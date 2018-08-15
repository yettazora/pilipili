package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.tagInfo;

public interface tagInfoMapper {
    int insert(tagInfo record);

    int insertSelective(tagInfo record);
}