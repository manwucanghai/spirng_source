package com.zws.spring.web.controller;

import com.zws.spring.web.event.ConsumerApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengws
 * @date 2020-02-21 22:55
 */
@RestController
@RequestMapping(value = "test")
public class AnnotationController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "hello")
    public void hello() {
        System.out.println("Hello World");
        applicationContext.publishEvent(new ConsumerApplicationEvent(applicationContext));
    }

    @RequestMapping(value = "execption")
    public void execption() {
        System.out.println("execption.....");
        throw new RuntimeException("执行异常");
    }

    @RequestMapping(value = "requestParams")
    public void requestParams(String name, Integer age) {
        System.out.println("integer");
        System.out.println(name);
        System.out.println(age);
    }
}
