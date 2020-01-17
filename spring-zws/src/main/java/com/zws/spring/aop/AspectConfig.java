package com.zws.spring.aop;

import com.zws.spring.service.IUserService;
import com.zws.spring.service.UserAService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-16 10:06
 */
//@Aspect
//@Component
public class AspectConfig {

//	/**
//	 * 测试采用@DeclareParents 为某个类(com.zws.spring.service.NotMethodService), 增强特定功能(IUserService)
//	 */
//	@DeclareParents(value = "com.zws.spring.service.NotMethodService", defaultImpl = UserAService.class)
//	public static IUserService iUserService;

//	@Pointcut("execution(* com.zws.spring.service.NotMethodService(..))")
//	private void pointcut(){}

	/**
	 * 当前对象，也就是代理对象
	 * JDK代理的实现方式是基于接口实现，代理类继承Proxy，实现接口
	 * proxyTargetClass 如果设置为false的话，则采用JDK动态代理，这种方式就无法进行匹配到
	 * proxyTargetClass 如果设置为true的话，则是采用GCLB方式，是通过继承来实现，因此可以匹配到。
	 */
	@Pointcut("this(com.zws.spring.service.UserAService)")
	public void pointCutThis(){}


	/**
	 * 目标对象，也就是被代理的对象
	 * CGLIB继承被代理的类来实现, 所以使用target会保证目标不变，关联对象不会受到proxyTargetClass设置的影响。
	 */
	@Pointcut("target(com.zws.spring.service.UserAService)")
	public void pointCutTarget(){}


	@Before(value = "pointCutThis()")
	public void doSomeThing(){
		System.out.println("do some thing ...");
	}

}
