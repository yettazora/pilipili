package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.templateInfo;

public interface templateInfoMapper {
    int insert(templateInfo record);

    int insertSelective(templateInfo record);
}