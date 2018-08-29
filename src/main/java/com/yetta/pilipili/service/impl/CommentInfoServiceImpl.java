package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.CommentInfoMapper;
import com.yetta.pilipili.dao.ReplyInfoMapper;
import com.yetta.pilipili.entity.CommentInfo;
import com.yetta.pilipili.entity.ReplyInfo;
import com.yetta.pilipili.entity.UserInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.CommentInfoService;
import com.yetta.pilipili.util.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service("commentInfoSerivce ")
public class CommentInfoServiceImpl implements CommentInfoService {

    @Autowired
    CommentInfoMapper commentInfoMapper;

    @Autowired
    ReplyInfoMapper replyInfoMapper;

    /**
     * 获得某个视频的评论条数
     * @param videoId 视频ID
     * @return
     */
    @Override
    public int getCnmmentCount(Integer videoId) {
        //评论条数
        int commentCount=commentInfoMapper.countByVideoId(videoId);
        //回复条数
        int replyCount=replyInfoMapper.countByVideoId(videoId);

        return commentCount+replyCount;

    }

    /**
     * 根据视频ID获取评论列表
     * @param videoId
     * @return
     */
    @Override
    public List<CommentInfo> listByVideoId(Integer videoId) {
        List<CommentInfo> list = commentInfoMapper.listByVideoId(videoId);
        if (list!=null && list.isEmpty()==false) {
            int len = list.size();
            for (int i=0; i<len; i++) {
                // 查询该评论下的回复列表
                List<ReplyInfo> replyInfoList = replyInfoMapper.listByCommentId(list.get(i).getId());

                list.get(i).setReplyInfoList(replyInfoList);
            }
        }


        return list;
    }


    /**
     * 保存用户评论
     * @param videoId
     * @param content
     * @param userInfo
     * @throws SystemException
     */
    @Override
    public void save(Integer videoId, String content, UserInfo userInfo) throws SystemException {
        //校验评论内容
        if (StringUtils.isEmpty(content)){
            throw new SystemException(ErrorMsg.ERROR_900001);
        }

        // 删除普通标签
//        content = content.replaceAll("<(S*?)[^>]*>.*?|<.*? />", "");
        // 删除转义字符
//        content = content.replaceAll("&.{2,6}?;", "");

        Date currentTime=new Date();
        CommentInfo commentInfo=new CommentInfo();

        commentInfo.setLoginName(userInfo.getLoginName());
        commentInfo.setUpdateTime(currentTime);
        commentInfo.setUserId(userInfo.getId());
        commentInfo.setVideoId(videoId);
        commentInfo.setContent(content);

        commentInfoMapper.insert(commentInfo);
    }
}
