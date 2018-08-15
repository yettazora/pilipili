package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.channelInfo;

public interface channelInfoMapper {
    int insert(channelInfo record);

    int insertSelective(channelInfo record);
}