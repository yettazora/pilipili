package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.MediaInfo;
import com.yetta.pilipili.entity.TypeInfo;
import com.yetta.pilipili.exception.SystemException;

import java.util.List;
import java.util.Map;

public interface MediaInfoService {
    Map<String,Object> selectByMediaId(Integer mediaId) throws SystemException;

    List<Integer> search(String keyWord);

    List<Map<String,Object>> getRankDataByApiId(Integer apiId) throws SystemException;

    MediaInfo selectById(Integer mediaId);

    List<MediaInfo> list(Map<String, Object> param);

    void save(Map<String, Object> param) throws SystemException;

    Map<String,Object> selectByIdAndTypeId(String mediaId, Integer typeId);

    void batchUpdateStatus(Map<String, Object> param);

    void batchUpdateType(Map<String, Object> param);

    void batchDelete(Integer[] mediaIdArr);

    String selectBiaotiById(Integer mediaId);
}
