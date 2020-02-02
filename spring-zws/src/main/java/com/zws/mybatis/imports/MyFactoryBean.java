package com.zws.mybatis.imports;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author zhengws
 * @date 2020-02-02 11:00
 */
public class MyFactoryBean<T> implements FactoryBean<T>{

	private Class<T> clazz;

	public MyFactoryBean(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T getObject() throws Exception {
		return (T) Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), new Class[]{clazz}, new MyMapperInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}
}
