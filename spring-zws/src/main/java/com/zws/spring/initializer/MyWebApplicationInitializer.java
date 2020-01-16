package com.zws.spring.initializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 模拟Tomcat 启动应用测试
 */
@ComponentScan(value = {"com.zws.spring.service", "com.zws.spring.controller"})
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("=============onstartup=============");
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MyWebApplicationInitializer.class);
//        ac.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("mvc", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
}