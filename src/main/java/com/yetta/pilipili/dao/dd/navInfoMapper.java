package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.navInfo;

public interface navInfoMapper {
    int insert(navInfo record);

    int insertSelective(navInfo record);
}