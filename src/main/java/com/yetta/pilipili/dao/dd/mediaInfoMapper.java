package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.mediaInfo;

public interface mediaInfoMapper {
    int insert(mediaInfo record);

    int insertSelective(mediaInfo record);
}