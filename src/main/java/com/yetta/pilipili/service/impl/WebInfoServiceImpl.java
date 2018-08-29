package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.WebInfoMapper;
import com.yetta.pilipili.entity.WebInfo;
import com.yetta.pilipili.service.WebInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("WebInfoService ")
public class WebInfoServiceImpl implements WebInfoService {

    @Autowired
    WebInfoMapper webInfoMapper;

    @Override
    public WebInfo select() {
        return webInfoMapper.select();
    }

    @Override
    public void save(WebInfo webInfo) {
        webInfoMapper.update(webInfo);
    }
}
