package com.zws.spring.service;

import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-12 20:25
 */
@Component
public class UserAService implements IUserService{

	private String name = "UserA";

	public UserAService() {
		System.out.println(this.hashCode());
		System.out.println("UserA Service constructor running ...");
	}

	@Override
	public String getName() {
		return this.name;
	}
}
