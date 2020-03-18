package com.zws.spring.web.initializer;

import com.zws.spring.web.config.AppConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

/**
 * @author zhengws
 * @date 2020-02-22 09:45
 */
public class MyDispatcherServletInitializer extends AbstractDispatcherServletInitializer {
    /**
     * 创建WebApplicationContext
     * @return
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        System.out.println("MyDispatcherServletInitializer createServletApplicationContext running ...");
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        return ac;
    }

    /**
     * 添加Servlet过滤器。
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }

    /**
     * 提供用户定制设置
     * @param registration the {@code DispatcherServlet} registration to be customized
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

    }

    /**
     * 配置ServletMappings.
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 创建RootApplicationContext
     * 正常用于多容器数据传递等常见，一般只需要单容器就够了
     * @return
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
