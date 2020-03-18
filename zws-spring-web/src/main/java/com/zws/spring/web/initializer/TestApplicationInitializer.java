package com.zws.spring.web.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author zhengws
 * @date 2020-02-21 23:53
 */
public class TestApplicationInitializer implements IApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("############## TestApplicationInitializer onStartup ##############");
    }
}
