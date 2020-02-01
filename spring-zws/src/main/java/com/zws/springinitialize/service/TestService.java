package com.zws.springinitialize.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zhengws
 * @date 2020-01-18 21:05
 */
@Service
public class TestService implements InitializingBean {
	public TestService() {
		System.out.println("TestService constructor..");
	}

	@PostConstruct
	private void init(){
		System.out.println("TestService init method ...");
	}

	public String query() {
		return "Test Service Query";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet...");
	}
}
