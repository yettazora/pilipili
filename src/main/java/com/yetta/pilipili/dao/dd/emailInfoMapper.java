package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.emailInfo;

public interface emailInfoMapper {
    int insert(emailInfo record);

    int insertSelective(emailInfo record);
}