package com.yetta.pilipili.test;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        String a="qwe   rty uoioo ie   ";
        String b=a.replaceAll("\\s", "");
        System.out.println(b);

        String a1="1234";
        System.out.println(a1.indexOf("123"));

//        File file=new File("/home/yetta/Pictures/test1.jpeg");
//        String fileName=file.getName();
//        FileInputStream in=new FileInputStream(file);
//        FileOutputStream out=new FileOutputStream("src/main/webapp/static/default/images/user_avatar/"+fileName);
//        byte[] bytes=new byte[1024];
//        int len=0;
//        while ((len=in.read(bytes))!=-1){
//            out.write(bytes);
//        }
//        out.close();
//        in.close();

        A a2=new A();
        A a3=new B();
        B b1=new B();

        System.out.println(a2.a+"    "+a2.b);
        a2.get();
        a2.get2();

        System.out.println(a3.a+"    "+a3.b);
        a3.get();
        a3.get2();

        System.out.println(b1.a+"    "+b1.b);
        b1.get2();
        b1.get();
    }


}
class A {
    public int a=1;

    public static int b=1;

    public static void get(){
        System.out.println("A的静态方法");
    }

    public void get2(){
        System.out.println("A的非静态");
    }

}
class B extends A{
    public int a=2;

    public static int b=2;

    public static void get(){
        System.out.println("B的静态方法");
    }

    public void get2(){
        System.out.println("B的非静态方法");
    }
}