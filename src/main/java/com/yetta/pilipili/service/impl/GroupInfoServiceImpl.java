package com.yetta.pilipili.service.impl;

import java.util.List;

import com.yetta.pilipili.dao.GroupInfoMapper;
import com.yetta.pilipili.dao.UserProfileInfoMapper;
import com.yetta.pilipili.entity.GroupInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.util.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service("GroupInfoService")
public class GroupInfoServiceImpl {
	@Autowired
	private GroupInfoMapper groupInfoMapper;
	@Autowired
	private UserProfileInfoMapper userProfileInfoMapper;
	
	/**
	 * 查询用户组列表
	 */
	public List<GroupInfo> list() {
		return groupInfoMapper.list();
	}

	/**
	 * 保存用户组
	 * @param groupInfoList
	 * @throws SystemException
	 */
	public void save(List<GroupInfo> groupInfoList) throws SystemException {
		for (GroupInfo groupInfo : groupInfoList) {
			if (StringUtils.isEmpty(groupInfo.getId())) {
				// 插入
				// 判断组名是否重复
				int count = groupInfoMapper.countByName(groupInfo.getName(), null);
				if (count>0) {
					throw new SystemException(ErrorMsg.ERROR_110001);
				}
				groupInfo.setType("user");
				groupInfoMapper.insert(groupInfo);
			} else {
				// 更新
				// 判断组名是否重复（排除自己）
				int count = groupInfoMapper.countByName(groupInfo.getName(), groupInfo.getId());
				if (count>0) {
					throw new SystemException(ErrorMsg.ERROR_110001);
				}
				groupInfoMapper.update(groupInfo);
			}
		}
	}

	/**
	 * 删除用户组
	 * @param idArr 用户组主键数组
	 * @throws SystemException
	 */
	public void delete(Integer[] idArr) throws SystemException {
		// 判断所选用户组有没有被使用的
		for (int i=0; i<idArr.length; i++) {
			int count = userProfileInfoMapper.countByGroupId(idArr[i]);
			if (count>0) {
				throw new SystemException(ErrorMsg.ERROR_110002);
			}
		}
		
		// 批量删除用户组
		groupInfoMapper.delete(idArr);
	}

	/**
	 * 查询用户权限值
	 * @param id
	 * @return
	 */
	public int selectPowerByUserId(Integer id) {
		return groupInfoMapper.selectPowerByUserId(id);
	}

}
