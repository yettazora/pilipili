package com.yetta.pilipili.util;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

/**
 * 根据图片地址转化为base64编码
 *
 * @author yetta
 */
public class ImgBase64 {
    public static String getImgBase64(String imgFile){
        InputStream inputStream=null;
        byte data[]=null;

        try {
            inputStream=new FileInputStream(imgFile);
            data=new byte[inputStream.available()]; //available()返回文件的大小
            inputStream.read(data);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        这里使用 Base64.encodeBase64String(b) 而不使用
//        BASE64Encoder encoder = new BASE64Encoder();
//        encoder.encode(data);//返回Base64编码过的字节数组字符串
//        因为根据RFC822规定，BASE64Encoder编码每76个字符，还需要加上一个回车换行
//        部分Base64编码的Java库还按照这个标准实行。
//        换用Apache的 commons-codec.jar， Base64.encodeBase64String(byte[]）得到的编码字符串是不带换行符的。
        String imgStr=Base64.encodeBase64String(data);

        return "data:image/jpeg;base64,"+imgStr;
    }

    public static void main(String[] args) throws IOException {
        String a=ImgBase64.getImgBase64("/home/yetta/Pictures/test1.jpeg");
        System.out.println(a);
        System.out.println(a.substring(22));
        System.out.println(a.indexOf("/"));
        int b=a.indexOf("/");
        int c=a.indexOf(";");
        int d=a.indexOf(",");
        System.out.println(a.substring(b+1, c));
        System.out.println(a.substring(c+1, d));
        System.out.println(a.substring(d+1));
        byte[]aa=Base64.decodeBase64(a.substring(d+1));
        OutputStream out=new FileOutputStream("src/main/webapp/static/default/images/user_avatar/"+"nini."+a.substring(b+1, c));
        out.write(aa);
        out.close();

    }
}
