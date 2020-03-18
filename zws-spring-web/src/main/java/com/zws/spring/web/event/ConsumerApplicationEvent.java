package com.zws.spring.web.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhengws
 * @date 2020-02-22 08:54
 */
public class ConsumerApplicationEvent extends ApplicationEvent {

    public String type = "Consumer";

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ConsumerApplicationEvent(Object source) {
        super(source);
    }
}
