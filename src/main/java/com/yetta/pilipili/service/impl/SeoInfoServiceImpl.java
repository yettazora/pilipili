package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.SeoInfoMapper;
import com.yetta.pilipili.entity.SeoInfo;
import com.yetta.pilipili.service.SeoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("seoInfoService")
public class SeoInfoServiceImpl implements SeoInfoService {

    @Autowired
    private SeoInfoMapper seoInfoMapper;

    /**
     * 根据类型,查询seo信息
     * @param type
     * @return
     */
    @Override
    public SeoInfo selectByType(String type) {
        return seoInfoMapper.selectByType(type);
    }

    /**
     * 保存seo配置
     * @param seoInfo
     */
    @Override
    public void save(SeoInfo seoInfo) {
        seoInfoMapper.update(seoInfo);
    }
}
