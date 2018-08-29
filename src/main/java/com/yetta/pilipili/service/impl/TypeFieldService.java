package com.yetta.pilipili.service.impl;

import java.util.List;

import com.yetta.pilipili.dao.FieldInfoMapper;
import com.yetta.pilipili.dao.MediaInfoMapper;
import com.yetta.pilipili.dao.TypeFieldMapper;
import com.yetta.pilipili.entity.TypeField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("TypeFieldService")
public class TypeFieldService {
	@Autowired
	private TypeFieldMapper typeFieldMapper;
	@Autowired
	private FieldInfoMapper fieldInfoMapper;
	@Autowired
	private MediaInfoMapper mediaInfoMapper;
	
	/**
	 * 根据分类信息主键，查询该分类下的字段配置
	 * @param typeId 分类信息主键
	 * @return
	 */
	public List<TypeField> listByTypeId(Integer typeId) {
		return typeFieldMapper.listByTypeId(typeId);
	}

	/**
	 * 保存某个分类信息下的字段配置
	 * @param typeId 分类信息主键
	 * @param typeFieldList
	 * @param fieldIdArr 字段主键数组
	 */
	public void save(Integer typeId, List<TypeField> typeFieldList, Integer[] fieldIdArr) {
		// 1.0 删除该分类下的所有字段配置
		typeFieldMapper.deleteByTypeId(typeId);
		
		// 2.0 批量插入分类信息下的字段配置
		typeFieldMapper.batchInsert(typeFieldList);
		
		// 3.0 生成关联字段
		// 3.1 获取字段的变量名集合
		List<String> list = fieldInfoMapper.listVarNameByIdArr(fieldIdArr);
		if (list!=null && list.isEmpty()==false) {
			int len = list.size();
			for (int i=0; i<len; i++) {
				String varName = list.get(i);
				
				StringBuffer sql = new StringBuffer();
				sql.append(" IF NOT EXISTS ( ");
				sql.append(" SELECT ");
				sql.append(" * ");
				sql.append(" FROM ");
				sql.append(" syscolumns ");
				sql.append(" WHERE ");
				sql.append(" id = object_id('media_info') ");
				sql.append(" AND name = '"+varName+"' ");
				sql.append(" ) ");
				sql.append(" BEGIN ");
				sql.append(" ALTER TABLE media_info ADD "+varName+" VARCHAR (100) ");
				sql.append(" END ");
				
				mediaInfoMapper.alter(sql.toString());
			}
		}
	}

	/**
	 * 检索指定字段是否必填
	 * @param typeId 分类信息主键
	 * @param varName 字段变量名
	 * @return
	 */
	public String selectIsRequired(Integer typeId, String varName) {
		return typeFieldMapper.selectIsRequired(typeId, varName);
	}
	
}
