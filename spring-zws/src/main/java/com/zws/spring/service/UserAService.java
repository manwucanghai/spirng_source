package com.zws.spring.service;

import com.zws.spring.annotation.ClassField;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-12 20:25
 */
@Component(value = "userAService")
@Scope("prototype")
@ClassField
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

	@Override
	public String getValue() {
		return "Hello World";
	}

	protected void printInfos(){
		System.out.println(this.name + " for UserA");
	}
}
