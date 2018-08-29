package com.yetta.pilipili.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * AES 是一种可逆的加密算法,对用户的敏感信息加密处理,对原始数据进行AES加密后,再进行Base64编码转化
 *
 * @author yetta
 */
public class AESEncryption {
    /**
     * 加密用的Key,可以用26个字母和数字组成,此处使用AES\-128-CBC加密模式,key需要16位
     */
    private String sKey="abcdef0123456789";
    private String ivParameter="0123456789abcdef";
    private static AESEncryption instance=null;

    private AESEncryption(){

    }

    //懒汉式加载单例模式
    public static AESEncryption getInstance(){
        if (instance==null){
            instance=new AESEncryption();
        }
        return instance;
    }

    //加密
    public String encrypt(String sSrc){
        String result="";
        try {
            Cipher cipher;
            cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw=sKey.getBytes();
            SecretKeySpec secretKeySpec=new SecretKeySpec(raw,"AES");
            IvParameterSpec ivParameterSpec=new IvParameterSpec(ivParameter.getBytes());
            //shiyongCBC加密,需要一个向量ivParameterSpec,可增强加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted=cipher.doFinal(sSrc.getBytes("utf-8"));
            result= Base64.encodeBase64String(encrypted);//此处使用BASE64做转码
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //解密
    public String decript(String sSrc){
        try {
            byte raw[]=sKey.getBytes("ASCII");
            SecretKeySpec secretKeySpec=new SecretKeySpec(raw,"AES");
            Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec=new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypt=Base64.decodeBase64(sSrc);//先做BASE64解密
            byte[] original=cipher.doFinal(encrypt);
            String originalString=new String(original,"utf-8");
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String cSrc="123456";//需要加密的字符串
        System.out.println(cSrc+"长度为"+cSrc.length());
        long start=System.currentTimeMillis();
        String enString=AESEncryption.getInstance().encrypt(cSrc);//加密
        System.out.println("加密后的字符串是:"+enString+"长度为"+enString.length());
        long useTime=System.currentTimeMillis()-start;
        System.out.println("加密耗时:"+useTime+"毫秒");
        start=System.currentTimeMillis();
        String deString=AESEncryption.getInstance().decript(enString);//解密
        System.out.println("解密后得字符串是:"+deString);
        useTime=System.currentTimeMillis()-start;
        System.out.println("解密耗时:"+useTime);


    }
}
