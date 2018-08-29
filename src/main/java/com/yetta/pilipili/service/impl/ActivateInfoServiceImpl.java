package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.ActivateInfoMapper;
import com.yetta.pilipili.entity.ActivateInfo;
import com.yetta.pilipili.service.ActivateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 保存认证记录
 *
 * @author yetta
 */
@Service("activateInfoService")
public class ActivateInfoServiceImpl implements ActivateInfoService {

    @Autowired
    private ActivateInfoMapper activateInfoMapper;

    /**
     * 保存验证记录
     * @param activateInfo
     */
    @Override
    public void save(ActivateInfo activateInfo) {
        //根据用户ID和验证类型,判断验证是否存在
        ActivateInfo activateInfo1=activateInfoMapper.selectByUserIdAndType(activateInfo.getUserId(), activateInfo.getType());
        //判断是否已经存在
        if (activateInfo1==null){
            //不存在,做插入操作
            activateInfoMapper.insert(activateInfo);
        }
        else {
            //存在,做更新操作
            activateInfo.setId(activateInfo1.getId());
            activateInfoMapper.update(activateInfo);
        }
    }

    /**
     * 根据用户ID和验证类型,判断验证是否以存在
     * @param userId 用户ID
     * @param type 验证类型
     * @return
     */
    @Override
    public ActivateInfo selectByUserIdAndType(Integer userId, String type) {
        return activateInfoMapper.selectByUserIdAndType(userId, type);
    }
}
