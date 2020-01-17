package com.zws.spring.service;

import com.zws.spring.annotation.ClassField;
import com.zws.spring.entity.UserInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-12 21:33
 */

@Component
@Scope("prototype")
public class UserBService implements IUserService {
	public UserBService() {
		System.out.println("UserB Service constructor running ...");
	}

	@Override
	public String getName() {
		return "B Name";
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

	public void printUserInfo(UserInfo info){
		System.out.println(info.name + info.age);
	}
}
