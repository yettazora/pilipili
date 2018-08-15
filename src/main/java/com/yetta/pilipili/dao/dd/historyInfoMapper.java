package com.yetta.pilipili.dao.dd;

import com.yetta.pilipili.entity.historyInfo;

public interface historyInfoMapper {
    int insert(historyInfo record);

    int insertSelective(historyInfo record);
}