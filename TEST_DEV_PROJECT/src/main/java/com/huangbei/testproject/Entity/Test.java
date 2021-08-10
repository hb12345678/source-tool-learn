package com.huangbei.testproject.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HHmmssSSS").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyyMMdd:HHmmssSSS").format(new Date()));
        String path ="20210806140344983_8sssss.properties";
        String name = path.substring(path.lastIndexOf("_")+1,path.length());
        String uid = path.substring(0,17);
        System.out.println(name);
        System.out.println(uid);
        System.out.println("我叫占巧凤");

    }
}
