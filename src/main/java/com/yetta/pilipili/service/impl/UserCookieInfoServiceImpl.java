package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.UserCookieInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userCookieInfoService")
public class UserCookieInfoServiceImpl {

    @Autowired
    UserCookieInfoMapper userCookieInfoMapper;

    
}
