package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.userProfileInfo;

public interface userProfileInfoMapper {
    int insert(userProfileInfo record);

    int insertSelective(userProfileInfo record);
}