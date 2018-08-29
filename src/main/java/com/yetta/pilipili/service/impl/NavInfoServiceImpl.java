package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.NavInfoMapper;
import com.yetta.pilipili.entity.NavInfo;
import com.yetta.pilipili.service.NavInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("navInfoService ")
public class NavInfoServiceImpl implements NavInfoService {

    @Autowired
    NavInfoMapper navInfoMapper;

    /**
     * 查询可用列表
     * @return
     */
    @Override
    public List<NavInfo> listIsUse() {
        return navInfoMapper.listIsUse();
    }
}
