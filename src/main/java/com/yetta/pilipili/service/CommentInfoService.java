package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.CommentInfo;
import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.exception.SystemException;

import java.util.List;

public interface CommentInfoService {

    int getCnmmentCount(Integer videoId);

    List<CommentInfo> listByVideoId(Integer videoId);

    void save(Integer videoId, String content, UserInfo userInfo) throws SystemException;
}
