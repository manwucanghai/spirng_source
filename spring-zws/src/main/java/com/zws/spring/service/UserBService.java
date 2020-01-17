package com.zws.spring.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-12 21:33
 */

@Component
@Scope("prototype")
public class UserBService implements IUserService{
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
}
