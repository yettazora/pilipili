package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.videoInfo;

public interface videoInfoMapper {
    int insert(videoInfo record);

    int insertSelective(videoInfo record);
}