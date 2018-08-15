package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.userInfo;

public interface userInfoMapper {
    int insert(userInfo record);

    int insertSelective(userInfo record);
}