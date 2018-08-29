package com.yetta.pilipili.service;

import com.yetta.pilipili.entity.EmailInfo;
import com.yetta.pilipili.exception.SystemException;

import java.util.List;

public interface EmailInfoService {
    void sendEmail(String toEmail,String subject,String content) throws SystemException;

    void getErrorMessage(String error) throws SystemException;

    List<EmailInfo> list();

    void save(List<EmailInfo> emailInfoList);

    void delete(Integer[] idArr);
}
