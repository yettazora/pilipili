package com.yetta.pilipili.service.impl;

import com.yetta.pilipili.dao.EmailInfoMapper;
import com.yetta.pilipili.dao.WebInfoMapper;
import com.yetta.pilipili.entity.EmailInfo;
import com.yetta.pilipili.entity.WebInfo;
import com.yetta.pilipili.exception.SystemException;
import com.yetta.pilipili.service.EmailInfoService;
import com.yetta.pilipili.util.ErrorMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

@Service("emailInfoService")
public class EmailInfoServiceImpl implements EmailInfoService {

    @Autowired
    WebInfoMapper webInfoMapper;

    @Autowired
    EmailInfoMapper emailInfoMapper;



    /**
     * 检测邮件发送
     * @param id 邮件设置表的主键
     * @param toEmail 收件人的邮箱
     * @throws SystemException
     */
    public void emailTest(Integer id, String toEmail) throws SystemException {
        WebInfo webInfo = webInfoMapper.select();
        String webName = webInfo.getName();

        // 返回错误信息
        String error = "";

        EmailInfo emailInfo = emailInfoMapper.selectById(id);
        // 发信人邮件地址、密码
        final String fromaddress = emailInfo.getEmail();
        final String password = emailInfo.getPassword();

        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        // 此处填写SMTP服务器
        props.put("mail.smtp.host", emailInfo.getSmtp());
        // 端口号
        props.put("mail.smtp.port", emailInfo.getPort());

//        props.put("mail.transport.protocol", "smtp");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 发件人用户名、密码
                return new PasswordAuthentication(fromaddress, password);
            }
        };

        // 使用环境属性和授权信息，创建邮件会话
        Session session = Session.getInstance(props, authenticator);

        // 创建邮件消息
        MimeMessage message = new MimeMessage(session);
        try {
            // 设置发件人
            if (StringUtils.isEmpty(webName)) {
                // 站点名称未设置时，使用默认昵称
                InternetAddress from = new InternetAddress(fromaddress);
                message.setFrom(from);
            } else {
                // 否则使用站点名称作为昵称
                String from = fromaddress;
                String nickname = "";
                try {
                    nickname = javax.mail.internet.MimeUtility.encodeText(webName);
                } catch (UnsupportedEncodingException e) {
                    error = e.getMessage();
                    e.printStackTrace();
                }
                message.setFrom(new InternetAddress(nickname + " <"+from+">"));
            }

            // 设置收件人的邮箱
            InternetAddress to = new InternetAddress(toEmail);
            message.setRecipient(Message.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject("测试邮件");

            // 设置邮件的内容体
            String content = "";
            if (StringUtils.isEmpty(webName)) {
                content = "这是一封测试邮件";
            } else {
                content = "这是一封来自" + webName + "的测试邮件";
            }
            message.setContent(content, "text/html;charset=UTF-8");

            // 发送邮件
            Transport.send(message);
        } catch (AddressException e) {
            error = e.getMessage();
        } catch (MessagingException e) {
            error = e.getMessage();
        } finally {
            getErrorMessage(error);
        }
    }



    /**
     * 发送邮件
     * @param toEmail 发送邮件地址
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws SystemException
     */
    @Override
    public void sendEmail(String toEmail, String subject, String content) throws SystemException {
        //获取站点信息
        WebInfo webInfo=webInfoMapper.select();
        String webName=webInfo.getName();

        String error="";
        List<EmailInfo> emailInfoList=emailInfoMapper.list();
        if (emailInfoList==null||emailInfoList.size()==0){
            throw new SystemException(ErrorMsg.ERROR_120008);
        }

        //遍历邮件设置列表,尝试每一条记录直到成功,或者失败
        for (EmailInfo emailInfo:emailInfoList){
            //发件人的邮箱地址,和密码
            final String fromAddress=emailInfo.getEmail();
            final String passWord=emailInfo.getPassword();

            //用Properties类记录邮箱的一些属性
            Properties properties=new Properties();
            //表示SMTP发送邮件,必须进行身份验证
            properties.put("mail.smtp.auth", "true");
            //此处填写SMTP服务器
            properties.put("mail.smtp.host", emailInfo.getSmtp());
            //端口号
            properties.put("mail.smtp.port", emailInfo.getPort());

            //构建授权信息,用于SMTP进行身份验证
            Authenticator authenticator=new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //发件人邮件地址和密码
                    return new PasswordAuthentication(fromAddress,passWord);
                }
            };

            //使用环境属性和授权信息,构建邮件会话
            Session session=Session.getInstance(properties, authenticator);

            //创建邮件信息
            MimeMessage mimeMessage=new MimeMessage(session);

            try {
                //设置发件人
                if (StringUtils.isEmpty(webName)){
                    //站点名称未设置时,使用默认昵称
                    InternetAddress from=new InternetAddress(fromAddress);
                    mimeMessage.setFrom(from);

                }
                else {
                    //否则使用站点名称作为昵称
                    String from=fromAddress;
                    String nickName="";
                    try {
                        nickName= MimeUtility.encodeText(webName);
                    } catch (UnsupportedEncodingException e) {
                        error=e.getMessage();
                        e.printStackTrace();
                    }
                    mimeMessage.setFrom(new InternetAddress(nickName+"<"+from+">"));
                }

                //设置收件人邮箱
                InternetAddress to=new InternetAddress(toEmail);
                mimeMessage.setRecipient(Message.RecipientType.TO, to);

                //设置邮件标题
                mimeMessage.setSubject(subject);

                //设置邮件内容体
                mimeMessage.setContent(content,"text/html;charset=utf-8");

                //发送邮件
                Transport.send(mimeMessage);

                //成功就直接返回
                break;

            } catch (AddressException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            finally {
                if (emailInfoList.size()==1){
                    getErrorMessage(error);
                }
            }
        }

        if (!StringUtils.isEmpty(error)){
            throw new SystemException(ErrorMsg.ERROR_120007);
        }
    }

    /**
     * 获取邮件发送异常对应的错误信息
     * @param error
     * @throws SystemException
     */
    @Override
    public void getErrorMessage(String error) throws SystemException {
        if (!StringUtils.isEmpty(error)){
            if (error.indexOf("422")>=0){
                throw new SystemException(ErrorMsg.ERROR_120002);
            }
            if (error.indexOf("501")>=0){
                throw new SystemException(ErrorMsg.ERROR_120003);
            }
            if (error.indexOf("503")>=0){
                throw new SystemException(ErrorMsg.ERROR_120004);
            }
            if (error.indexOf("523")>=0){
                throw new SystemException(ErrorMsg.ERROR_120004);
            }
            if (error.indexOf("535")>=0){
                throw new SystemException(ErrorMsg.ERROR_120006);
            }

            throw new SystemException(ErrorMsg.ERROR_120007);
        }
    }

    /**
     * 查询邮件设置列表
     */
    public List<EmailInfo> list() {
        return emailInfoMapper.list();
    }

    /**
     * 保存邮件设置
     * @param emailInfoList
     */
    public void save(List<EmailInfo> emailInfoList) {
        for (EmailInfo emailInfo : emailInfoList) {
            if (StringUtils.isEmpty(emailInfo.getId())) {
                // 插入
                emailInfoMapper.insert(emailInfo);
            } else {
                // 更新
                emailInfoMapper.update(emailInfo);
            }
        }
    }


    /**
     * 删除邮件设置
     * @param idArr 邮件设置主键数组
     * @throws SystemException
     */
    @Override
    public void delete(Integer[] idArr) {
        // 批量删除邮件设置
        emailInfoMapper.delete(idArr);
    }

}
