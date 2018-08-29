package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.ApiInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ApiInfoMapper {

    /**
     * 查询指定类型接口列表
     * @param type 接口类型
     * @return
     */
    List<ApiInfo> listByType(@Param("type") String type);

    /**
     * 插入新的接口
     * @param apiInfo
     * @return
     */
    int insert(ApiInfo apiInfo);

    /**
     * 更新接口
     * @param apiInfo
     * @return
     */
    int update(ApiInfo apiInfo);

    /**
     * 批量删除接口
     * @param idArr 主键数组
     * @return
     */
    int delete(@Param("idArr") Integer idArr[]);

    /**
     * 根据主键,获得接口设置
     * @param id 主键
     * @return
     */
    Map<String,Object> selectById(Integer id);


    /**
     * 判断字段有没有被接口使用
     * @param field
     * @return
     */
    int countByField(@Param("field") String field);

    /**
     * 向接口表中添加字段
     * @param alterSql
     */
    void alter(@Param("alterSql") String alterSql);

    /**
     * 保存排行榜条件设置
     * @param apiInfo
     * @return
     */
    int updateRankSet(ApiInfo apiInfo);
}