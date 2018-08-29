package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.TemplateInfoMapper;
import com.yetta.pilipili.entity.TemplateInfo;
import com.yetta.pilipili.service.TemplateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("templateInfoService")
public class TemplateInfoServiceImpl implements TemplateInfoService {

    @Autowired
    TemplateInfoMapper templateInfoMapper;

    /**
     * 根据类型查询所选的模板
     * @param type
     * @return
     */
    @Override
    public TemplateInfo selectByType(String type) {
        return templateInfoMapper.selectByType(type);
    }

    /**
     * 保存模板风格的配置
     * @param templateInfo
     */
    @Override
    public void save(TemplateInfo templateInfo) {
        templateInfoMapper.update(templateInfo);
    }

    /**
     * 根据类型查询对应模板的名字
     * @param type
     * @return
     */
    @Override
    public String selectNameByType(String type) {
        return templateInfoMapper.selectNameByType(type);
    }
}
