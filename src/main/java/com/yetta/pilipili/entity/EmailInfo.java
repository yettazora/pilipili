package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 邮件设置表
 *
 * @author yetta
 */
public class EmailInfo implements Serializable {
    private Integer id;         //主键

    private String smtp;        //SMTP服务器

    private Integer port;       //端口

    private String email;       //发信人邮件地址

    private String password;    //STMP身份验证密码

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp == null ? null : smtp.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}