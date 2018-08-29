package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.UserProfileInfoMapper;
import com.yetta.pilipili.entity.UserProfileInfo;
import com.yetta.pilipili.service.UserProfileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userProfileInfoService ")
public class UserProfileInfoServiceImpl implements UserProfileInfoService {

    @Autowired
    private UserProfileInfoMapper userProfileInfoMapper;

    /**
     * 保存用户拓展信息
     * @param userProfileInfo
     */
    @Override
    public void save(UserProfileInfo userProfileInfo) {
        userProfileInfoMapper.update(userProfileInfo);
    }
}
