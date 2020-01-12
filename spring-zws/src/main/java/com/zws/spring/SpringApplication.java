package com.zws.spring;

import com.zws.spring.service.UserAService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhengws
 * @date 2020-01-12 20:08
 */

@ComponentScan(value = {"com.zws.spring"})
public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(SpringApplication.class);
		ac.refresh();

		System.out.println(ac.getBean(UserAService.class));
		System.out.println(ac.getBean("userAService"));
		System.out.println(ac.getBean("AService"));
	}
}
