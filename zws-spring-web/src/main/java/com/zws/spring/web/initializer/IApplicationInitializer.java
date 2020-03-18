package com.zws.spring.web.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author zhengws
 * @date 2020-02-21 23:52
 */
public interface IApplicationInitializer {
    /**
     * 启动自动调用该方法.
     * @param servletContext
     * @throws ServletException
     */
    void onStartup(ServletContext servletContext) throws ServletException;
}
