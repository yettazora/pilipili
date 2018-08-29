package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.VideoInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VideoInfoMapper {
    /**
     * 根据媒体信息主键，查询该视频下的所有播放集数，从小到大排序（状态正常的）
     * @param mediaId 媒体信息主键
     * @return
     */
    List<VideoInfo> listByMediaId(@Param("mediaId") Integer mediaId);

    /**
     * 根据媒体信息主键，查询该视频下的所有播放集数，从大到小排序（后台管理专用）
     * @param mediaId 媒体信息主键
     * @return
     */
    List<VideoInfo> listByMediaIdDesc(@Param("mediaId") Integer mediaId);


    /**
     * 根据主键查询信息
     * @param videoId 主键
     * @return
     */
    VideoInfo selectById(Integer videoId);

    /**
     * 插入一条新数据
     * @param videoInfo
     * @return
     */
    int insert(VideoInfo videoInfo);

    /**
     * 更新一条数据
     * @param videoInfo
     * @return
     */
    int update(VideoInfo videoInfo);

    /**
     * 查询该视频下的第一集
     * @param mediaId 媒体信息主键
     * @return
     */
    VideoInfo selectByMediaIdFirst(Integer mediaId);

    /**
     * 查询该视频下的最新一集
     * @param mediaId 媒体信息主键
     * @return
     */
    VideoInfo selectByMediaIdLast(Integer mediaId);

    /**
     * 查询使用该播放器的视频个数
     * @param playerId
     * @return
     */
    int countByPlayerId(Integer playerId);

    /**
     * 更新统一封面
     * @param mediaId 媒体信息主键
     * @param image 图片地址
     * @return
     */
    int updateImage(@Param("mediaId") Integer mediaId, @Param("image") String image);

    /**
     * 根据媒体主键和第几集，查询是否存在既存数据
     * @param mediaId 媒体主键
     * @param num 第几集
     * @return
     */
    VideoInfo selectByMediaIdAndNum(@Param("mediaId") Integer mediaId, @Param("num") String num);

    /**
     * 批量更新视频状态
     * @param videoIdArr 主键数组
     * @param status 状态
     * @return
     */
    int batchUpdateStatus(@Param("videoIdArr") Integer[] videoIdArr, @Param("status") Integer status);

    /**
     * 批量删除
     * @param videoIdArr 主键数组
     * @return
     */
    int batchDelete(@Param("videoIdArr") Integer[] videoIdArr);

    /**
     * 根据视频主键查询视频播放源
     * @param videoId
     * @return
     */
    VideoInfo selectVideoPlayById(Integer videoId);

    /**
     * 更新统一权限值
     * @param mediaId
     * @param power
     */
    int updatePower(@Param("mediaId") Integer mediaId, @Param("power") Integer power);

    /**
     * 获取最新视频
     * @param count 获取条数
     */
    List<VideoInfo> listNewVideo(@Param("count") Integer count);

    /**
     * 批量更新视频的状态
     * @param param
     * @return
     */
    int batchUpdate(Map<String, Object> param);

    /**
     * 清空视频点击量
     * @param videoInfo
     */
    int clearViewCount(VideoInfo videoInfo);

    /**
     * 获取视频信息（前台播放页面专用）
     * @param videoId 视频主键
     * @return
     */
    VideoInfo selectByIdWithPortal(Integer videoId);

    /**
     * 根据媒体主键数组，批量删除视频信息
     * @param mediaIdArr
     * @return
     */
    int batchDeleteByMediaId(@Param("mediaIdArr") Integer[] mediaIdArr);
}