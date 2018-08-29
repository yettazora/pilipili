package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.GroupInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupInfoMapper {
    /**
     * 查询用户组列表
     */
    List<GroupInfo> list();

    /**
     * 插入新的用户组
     * @param groupInfo
     * @return
     */
    int insert(GroupInfo groupInfo);

    /**
     * 更新用户组
     * @param groupInfo
     * @return
     */
    int update(GroupInfo groupInfo);

    /**
     * 批量删除用户组
     * @param idArr 主键数组
     * @return
     */
    int delete(@Param("idArr") Integer[] idArr);

    /**
     * 查询用户权限值
     * @param userId 用户主键
     * @return
     */
    int selectPowerByUserId(@Param("userId") Integer userId);

    /**
     * 查询用户组名的数量，用于校验名字重复
     * @param name 用户组名
     * @param id 主键
     * @return
     */
    int countByName(@Param("name") String name, @Param("id") Integer id);
}