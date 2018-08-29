package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.UserProfileInfo;

import java.util.Map;

public interface UserProfileInfoMapper {

    /**
     * 注册新用户
     * @param userProfileInfo
     */
    int insert(UserProfileInfo userProfileInfo);

    /**
     * 查询指定用户组的数量
     * @param groupId 用户组主键
     * @return
     */
    int countByGroupId(Integer groupId);

    /**
     * 保存用户信息
     * @param userProfileInfo
     */
    int update(UserProfileInfo userProfileInfo);

    /**
     * 批量更新用户
     * @param param
     */
    int batchUpdate(Map<String, Object> param);
}