package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.ActivateInfo;

public interface ActivateInfoService {
    void save(ActivateInfo activateInfo);

    ActivateInfo selectByUserIdAndType(Integer userId,String type);
}
