package com.zws.spring.web.listener;

import com.zws.spring.web.event.ConsumerApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-02-22 08:56
 */
@Component
public class ConsumerApplicationListener implements ApplicationListener<ConsumerApplicationEvent> {
    @Override
    public void onApplicationEvent(ConsumerApplicationEvent event) {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(event.type);
    }
}
