package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.playerInfo;

public interface playerInfoMapper {
    int insert(playerInfo record);

    int insertSelective(playerInfo record);
}