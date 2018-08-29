package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.VideoInfo;
import com.yetta.pilipili.exception.SystemException;

import java.util.List;

public interface VideoInfoService {

    VideoInfo selectByIdWithPortal(Integer videoId);

    String selectVideoPlayById(Integer videoId);

    List<VideoInfo> listByMediaId(Integer mediaId);

    List<VideoInfo> listByMediaIdDesc(Integer mediaId);

    VideoInfo selectById(Integer videoId);

    void save(VideoInfo videoInfo);

    void updatePower(Integer mediaId, Integer power);

    void updateSort(Integer[] videoIdArr, Integer[] sortArr);

    void batchUpdateStatus(Integer[] videoIdArr, Integer status);

    void batchDelete(Integer[] videoIdArr) throws SystemException;

    void updateImage(Integer mediaId, String imgUrl);
}
