package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.TemplateInfo;

public interface TemplateInfoService {

    TemplateInfo selectByType(String type);

    void save(TemplateInfo templateInfo);

    String selectNameByType(String type);
}
