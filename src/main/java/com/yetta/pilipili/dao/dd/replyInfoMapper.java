package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.replyInfo;

public interface replyInfoMapper {
    int insert(replyInfo record);

    int insertSelective(replyInfo record);
}