package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.seoInfo;

public interface seoInfoMapper {
    int insert(seoInfo record);

    int insertSelective(seoInfo record);
}