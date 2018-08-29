package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.ReplyInfoMapper;
import com.yetta.pilipili.entity.ReplyInfo;
import com.yetta.pilipili.service.ReplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("replyInfoService")
public class ReplyInfoServiceImpl implements ReplyInfoService {

    @Autowired
    ReplyInfoMapper replyInfoMapper;

    /**
     * 保存对用户的回复
     * @param replyInfo
     */
    @Override
    public void save(ReplyInfo replyInfo) {
        replyInfoMapper.insert(replyInfo);
    }
}
