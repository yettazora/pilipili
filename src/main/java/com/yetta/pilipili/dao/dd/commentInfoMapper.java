package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.commentInfo;

public interface commentInfoMapper {
    int insert(commentInfo record);

    int insertSelective(commentInfo record);
}