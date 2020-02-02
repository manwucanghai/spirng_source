package com.zws.mybatis.imports;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhengws
 * @date 2020-02-02 11:31
 */
public class MyMapperInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke call...");
		return null;
	}
}
