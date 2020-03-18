//package com.zws.spring.web.initializer;
//
//import com.zws.spring.web.config.AppConfig;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * 基于Servlet 3.0+规范，容器服务器启动时，基于SPI会扫描所有包的META-INF/services/javax.servlet.ServletContainerInitializer文件，
// * 1、读取该文件中所有的实现ServletContainerInitializer类 (Spring内部是SpringServletContainerInitializer)
// * 2、这些实现类中添加了@HandlesTypes注解，会自动扫描该注解中配置的接口的所有实现类 (Spring内部是WebApplicationInitializer)
// * 3、将这些实现类以数组的形式，传递给ServletContainerInitializer实现类的 onStartup(Set<Class<?>> c, ServletContext ctx)方法
// * 4、SpringServletContainerInitializer，会遍历所有WebApplicationInitializer实现类，
// *     并调用onStartup(ServletContext servletContext)方法，因此达到启动自动加载的目的
// *
// * @author zhengws
// * @date 2020-02-21 22:04
// */
//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        System.out.println("############ddddddddddd############");
//        // Load Spring web application configuration
//        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//        ac.register(AppConfig.class);
////        ac.refresh();
//
//        // Create and register the DispatcherServlet
//        DispatcherServlet servlet = new DispatcherServlet(ac);
//        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("*.do");
//    }
//}
