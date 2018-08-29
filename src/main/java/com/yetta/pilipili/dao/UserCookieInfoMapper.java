package com.yetta.pilipili.dao;

import com.yetta.pilipili.entity.UserCookieInfo;
import org.apache.ibatis.annotations.Param;

public interface UserCookieInfoMapper {

    int insert(UserCookieInfo userCookieInfo);


    UserCookieInfo selectByUserIdAndSessionId(@Param("userId") Integer userId,@Param("sessionId") String sessionId);

}