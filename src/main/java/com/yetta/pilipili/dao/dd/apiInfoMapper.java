package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.apiInfo;

public interface apiInfoMapper {
    int insert(apiInfo record);

    int insertSelective(apiInfo record);
}