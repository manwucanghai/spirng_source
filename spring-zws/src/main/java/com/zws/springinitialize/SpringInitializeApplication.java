package com.zws.springinitialize;

import com.zws.springinitialize.imports.NomalClass;
import com.zws.springinitialize.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 用于解读 Spring 初始化过程源码
 * @author zhengws
 * @date 2020-01-18 21:02
 */
@ComponentScan(value = {"com.zws.springinitialize"})
//@Import(value = {NomalClass.class})
public class SpringInitializeApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringInitializeApplication.class);

		TestService testService = ac.getBean(TestService.class);
		System.out.println(testService.query());

		NomalClass nomalClass = ac.getBean(NomalClass.class);
		nomalClass.print("Hello World");

	}
}
