package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.SeoInfo;

public interface SeoInfoService {
    SeoInfo selectByType(String type);

    public void save(SeoInfo seoInfo);
}
