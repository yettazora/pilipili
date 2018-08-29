package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.KeyWordInfo;

import java.util.List;

public interface KeyWordInfoMapper {
    int insert(KeyWordInfo keyWordInfo);

    int deleteById(Integer id);

    List<KeyWordInfo> list();
}