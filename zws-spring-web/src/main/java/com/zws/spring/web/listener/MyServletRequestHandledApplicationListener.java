package com.zws.spring.web.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author zhengws
 * @date 2020-02-22 20:08
 */
@Component
public class MyServletRequestHandledApplicationListener implements ApplicationListener<ServletRequestHandledEvent> {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        System.out.println("*********************");
        System.out.println(event);
        if (event.wasFailure()){
            throw new RuntimeException("全局错误异常");
        }
    }
}
