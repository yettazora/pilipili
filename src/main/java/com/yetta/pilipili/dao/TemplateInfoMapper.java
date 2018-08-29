package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.TemplateInfo;

public interface TemplateInfoMapper {

    /**
     * 根据类型查询已选的模板
     * @param type 类型
     * @return
     */
    TemplateInfo selectByType(String type);

    /**
     * 更新模板风格的配置
     * @param templateInfo
     * @return
     */
    int update(TemplateInfo templateInfo);

    /**
     * 获取类型对应的模板名称
     * @param type 类型
     * @return
     */
    String selectNameByType(String type);

}