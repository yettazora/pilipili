package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.slideInfo;

public interface slideInfoMapper {
    int insert(slideInfo record);

    int insertSelective(slideInfo record);
}