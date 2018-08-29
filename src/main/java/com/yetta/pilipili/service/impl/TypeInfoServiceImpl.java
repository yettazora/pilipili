package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.TypeInfoMapper;
import com.yetta.pilipili.entity.TypeInfo;
import com.yetta.pilipili.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("typeInfoService")
public class TypeInfoServiceImpl implements TypeInfoService {

    @Autowired
    TypeInfoMapper typeInfoMapper;

    /**
     * 根据主键查询分类信息
     * @param id 主键
     * @return
     */
    @Override
    public com.yetta.pilipili.entity.TypeInfo selectById(Integer id) {
        return typeInfoMapper.selectById(id);
    }

    /**
     * 查询分类列表
     */
    @Override
    public List<TypeInfo> list() {
        return typeInfoMapper.list();
    }

}
