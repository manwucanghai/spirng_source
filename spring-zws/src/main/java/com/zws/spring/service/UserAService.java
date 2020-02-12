package com.zws.spring.service;

import com.zws.spring.annotation.ClassField;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.beans.ConstructorProperties;

/**
 * @author zhengws
 * @date 2020-01-12 20:25
 */
@Component(value = "userAService")
//@Scope("prototype")
//@DependsOn(value = {"userBService"})
@ClassField
public class UserAService implements IUserService, InitializingBean {

	public UserBService userBService;

//	@ConstructorProperties(value = {"userBService"})
	// 可采用@Autowired或者@Inject选择特定的构造方法进行注入，多个构造方法只能添加一个@Autowired注解.
	@Autowired
//	@Inject
	public UserAService(UserBService userBService){
		this.userBService = userBService;
	}

//	@Autowired
	public UserAService(UserBService userBService, AService aService){
		System.out.println("ccccccc");
	}
	private String name = "UserA";

//	public UserAService() {
//		System.out.println(this.hashCode());
//		System.out.println("UserA Service constructor running ...");
//	}

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

	@PostConstruct
	public void initMethod1(){
		System.out.println("init method1 ....");
	}

	@PostConstruct
	public void initMethod2(){
		System.out.println("init method2 ....");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet init ...");
	}
}
