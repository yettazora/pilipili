package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.typeField;

public interface typeFieldMapper {
    int insert(typeField record);

    int insertSelective(typeField record);
}