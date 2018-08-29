package com.yetta.pilipili.service.impl;

import java.util.List;

import com.yetta.pilipili.dao.PlayerInfoMapper;
import com.yetta.pilipili.dao.VideoInfoMapper;
import com.yetta.pilipili.entity.PlayerInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.util.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service("PlayerInfoService")
public class PlayerInfoService {
	@Autowired
	private PlayerInfoMapper playerInfoMapper;
	@Autowired
	private VideoInfoMapper videoInfoMapper;
	
	/**
	 * 查询播放器列表
	 */
	public List<PlayerInfo> list() {
		return playerInfoMapper.list();
	}

	/**
	 * 批量保存播放器
	 * @param playerInfoList
	 */
	public void batchSave(List<PlayerInfo> playerInfoList) {
		for (PlayerInfo playerInfo : playerInfoList) {
			if (StringUtils.isEmpty(playerInfo.getId())) {
				// 插入
				playerInfoMapper.insert(playerInfo);
			} else {
				// 更新
				playerInfoMapper.update(playerInfo);
			}
		}
	}

	/**
	 * 删除播放器
	 * @param idArr 播放器主键数组
	 * @throws SystemException
	 */
	public void delete(Integer[] idArr) throws SystemException {
		// 判断所选播放器有没有被使用的
		for (int i=0; i<idArr.length; i++) {
			int nCount = videoInfoMapper.countByPlayerId(idArr[i]);
			if (nCount>0) {
				throw new SystemException(ErrorMsg.ERROR_400001);
			}
		}
		
		// 批量删除播放器
		playerInfoMapper.delete(idArr);
	}

	/**
	 * 根据主键查询播放器信息
	 * @param id 主键
	 * @return
	 */
	public PlayerInfo selectById(Integer id) {
		return playerInfoMapper.selectById(id);
	}

	/**
	 * 保存播放器
	 * @param playerInfo
	 */
	public void save(PlayerInfo playerInfo) {
		playerInfoMapper.update(playerInfo);
	}

}
