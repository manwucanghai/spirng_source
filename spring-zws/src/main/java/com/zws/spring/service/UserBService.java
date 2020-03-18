package com.zws.spring.service;

import com.zws.spring.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-12 21:33
 */

@Component
public class UserBService implements IUserService {

    private String name;

    @Autowired
    public IUserService userAService;

    public UserBService() {
        System.out.println("UserB Service constructor running ...");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getValue() {
        return "B Value";
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printMessageWithAge(String msg, Integer age) {
        System.out.println(msg + age);
    }

    public void printUserInfo(UserInfo info) {
        System.out.println(info.name + info.age);
        throw new NullPointerException();
    }
}
