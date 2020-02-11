package com.zws.spring.service;

import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-12 22:45
 */
//@Component
public abstract class AService {
    public void printService(){
        System.out.println(getService());
    }

    public abstract IUserService getService();
}
