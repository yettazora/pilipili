package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.webInfo;

public interface webInfoMapper {
    int insert(webInfo record);

    int insertSelective(webInfo record);
}