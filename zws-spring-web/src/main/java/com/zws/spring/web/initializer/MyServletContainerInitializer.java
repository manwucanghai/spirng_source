package com.zws.spring.web.initializer;

import org.springframework.util.ReflectionUtils;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author zhengws
 * @date 2020-02-21 23:47
 */
@HandlesTypes(IApplicationInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext ctx) throws ServletException {
        System.out.println("#############################");
        IApplicationInitializer initializer;
        System.out.println(classes);
        for (Class<?> clazz : classes) {
            if (IApplicationInitializer.class.isAssignableFrom(clazz)) {
                try {
                    initializer = (IApplicationInitializer) ReflectionUtils.accessibleConstructor(clazz).newInstance();
                    initializer.onStartup(ctx);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
