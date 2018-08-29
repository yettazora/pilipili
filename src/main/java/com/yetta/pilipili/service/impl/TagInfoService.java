package com.yetta.pilipili.service.impl;

import java.util.List;

import com.yetta.pilipili.dao.TagInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("TagInfoService")
public class TagInfoService {
	@Autowired
	private TagInfoMapper tagInfoMapper;

	/**
	 * 根据主键数组，查询名称集合
	 * @param idArr 主键数组
	 * @return
	 */
	public List<String> listNameByIdArr(Integer[] idArr) {
		return tagInfoMapper.listNameByIdArr(idArr);
	}
}
