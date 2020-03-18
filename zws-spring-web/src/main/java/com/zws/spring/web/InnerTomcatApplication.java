package com.zws.spring.web;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @author zhengws
 * @date 2020-02-21 23:11
 */
public class InnerTomcatApplication {
    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);

        String sourcePath = InnerTomcatApplication.class.getResource("/").getPath();
        System.out.println(sourcePath);

        Context ctx = tomcat.addWebapp("/", new File(sourcePath).getParent() + "/resources");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                sourcePath, "/"));

        ctx.setResources(resources);
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InnerTomcatApplication.run();
    }
}
