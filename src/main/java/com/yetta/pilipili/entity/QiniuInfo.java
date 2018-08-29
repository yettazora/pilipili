package com.yetta.pilipili.entity;

import java.io.Serializable;

/**
 * 七牛云配置表
 *
 * @author yetta
 */
public class QiniuInfo implements Serializable {

    private Integer id;         //主键

    private String type;        //类型

    private String ak;          //秘钥ak

    private String sk;          //秘钥sk

    private String bucket;      //空间名称

    private Integer width;      //自动裁剪后的宽度(0为不裁剪)

    private Integer height;     //自动裁剪后的高度(0为不裁剪)

    private Integer compress;   //压缩率(0为不压缩)

    private String name;        //名称

    private String domain;      //空间绑定域名

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak == null ? null : ak.trim();
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk == null ? null : sk.trim();
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket == null ? null : bucket.trim();
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getCompress() {
        return compress;
    }

    public void setCompress(Integer compress) {
        this.compress = compress;
    }

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
}