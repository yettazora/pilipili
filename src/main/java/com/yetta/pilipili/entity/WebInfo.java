package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 网站信息表
 *
 * @author yetta
 */
public class WebInfo implements Serializable {

    private String name;                //站点名称,将显示在浏览器窗口标题等位置

    private String domain;              //网站URL

    private String email;               //管理员E-Mail

    private String recordNumber;        //网站备案信息代码

    private String statisticalCode;     //网站第三方统计代码

    private Integer id;                 //主键

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber == null ? null : recordNumber.trim();
    }

    public String getStatisticalCode() {
        return statisticalCode;
    }

    public void setStatisticalCode(String statisticalCode) {
        this.statisticalCode = statisticalCode == null ? null : statisticalCode.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}