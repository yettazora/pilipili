package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.WebInfo;
import org.springframework.stereotype.Service;

public interface WebInfoService {

    /**
     * 查询网站信息
     * @return
     */
    WebInfo select();

    /**
     * 保存站点信息配置
     * @param webInfo
     */
    void save(WebInfo webInfo);
}
