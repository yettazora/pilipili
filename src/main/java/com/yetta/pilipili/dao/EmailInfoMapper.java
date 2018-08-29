package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.EmailInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmailInfoMapper {

    /**
     * 查看邮件设置列表
     * @return
     */
    List<EmailInfo> list();

    /**
     * 插入
     * @param emailInfo
     * @return
     */
    int insert(EmailInfo emailInfo);

    /**
     * 更新
     * @param emailInfo
     * @return
     */
    int update(EmailInfo emailInfo);

    /**
     * 删除
     * @param idArr 主键数组
     * @return
     */
    int delete(@Param("idArr") Integer idArr[]);

    /**
     * 根据主键查询记录信息
     * @param id
     * @return
     */
    EmailInfo selectById(@Param("id") Integer id);
}