package com.zws.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhengws
 * @date 2020-01-12 20:08
 */

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		TestService service = ac.getBean(TestService.class);
		System.out.println(service);
	}
}
