package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.CollectionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CollectionInfoMapper {

    /**
     * 判断该视频是否被用户收藏过了
     * @param mediaId 媒体主键
     * @param userId 用户ID
     * @return
     */
    int countByMediaIdAndUserId(@Param("mediaId") Integer mediaId,@Param("userId") Integer userId);

    /**
     * 添加视频收藏
     * @param collectionInfo
     * @return
     */
    int insert(CollectionInfo collectionInfo);

    /**
     * 删除收藏的视频
     * @param collectionInfo
     * @return
     */
    int delete(CollectionInfo collectionInfo);

    /**
     * 获得用户的收藏列表
     * @param userId 用户ID
     * @return
     */
    List<Map<String,Object>> listCollection(@Param("userId") Integer userId);

    /**
     * 删除收藏表中的内容
     * @param userIdArr 用户ID数组
     * @return
     */
    int deleteByUserIdArr(@Param("userIdArr") Integer userIdArr[]);
}