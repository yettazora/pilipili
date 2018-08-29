package com.yetta.pilipili.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 将传入的字符串进行MD5加密
 *
 * @author yetta
 */
public class MD5 {

    public static String md5(String data){
        try {
            byte[] md5=md5(data.getBytes("utf-8"));
            return toHexingString(md5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] md5(byte[] data){
        try {
            MessageDigest md=MessageDigest.getInstance("md5");
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[]{};
        }
    }

    public static String toHexingString(byte[] md5){
        StringBuilder stringBuilder=new StringBuilder();
        for (byte b:md5){
            stringBuilder.append(leftPad(Integer.toHexString(b & 0xff), '0', 2));
        }
        return stringBuilder.toString();
    }

    public static String leftPad(String hex,char c,int size){
        char[] cs=new char[size];
        Arrays.fill(cs, c);     //用字符c,填充满cs字符数组
        System.arraycopy(hex.toCharArray(), 0, cs, cs.length-hex.length(), hex.length());
        return new String(cs);
    }

    public static void main(String[] args){
        System.out.println(md5("111111").equals("96e79218965eb72c92a549dd5a330112"));
    }
}
