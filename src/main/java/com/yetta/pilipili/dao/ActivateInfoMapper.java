package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.ActivateInfo;
import org.apache.ibatis.annotations.Param;

public interface ActivateInfoMapper {
    /**
     * 根据用户ID和验证类型,判断验证是否以存在
     * @param userId 用户ID
     * @param type 验证类型
     * @return
     */
    ActivateInfo selectByUserIdAndType(@Param("userId") Integer userId,@Param("type") String type);

    /**
     * 插入
     * @param activateInfo
     * @return
     */
    int insert( ActivateInfo activateInfo);

    /**
     * 更新
     * @param activateInfo
     * @return
     */
    int update( ActivateInfo activateInfo);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(@Param("id") Integer id);

    /**
     * 获取验证记录
     * @param email
     * @param code
     * @param type
     * @return
     */
    ActivateInfo selectByEmailAndCodeAndType(@Param("email") String email,@Param("code") String code,@Param("type") String type);
}