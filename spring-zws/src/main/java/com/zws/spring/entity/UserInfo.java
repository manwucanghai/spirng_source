package com.zws.spring.entity;

import com.zws.spring.annotation.ClassField;

/**
 * @author zhengws
 * @date 2020-01-17 17:12
 */
@ClassField
public class UserInfo {
	public String name;
	public Integer age;

	public UserInfo(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
