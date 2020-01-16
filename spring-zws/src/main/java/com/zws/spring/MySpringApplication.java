package com.zws.spring;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * 模拟Tomcat 启动应用测试。
 * @author zhengws
 * @date 2020-01-13 22:50
 */
public class MySpringApplication {
    public static void run(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(9988);
            tomcat.addWebapp("/","/Users/zhengws/Desktop/spring/");
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MySpringApplication.run(args);
    }
}
