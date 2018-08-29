package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.TypeInfo;

import java.util.List;

public interface TypeInfoService {

    TypeInfo selectById(Integer id);

    List<TypeInfo> list();
}
