package com.zws.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-17 16:12
 */
@Aspect
@Component
public class AopExecution {
	/**
	 * 通用表达式，可针对修饰符、返回值类型、方法参数、异常类型 进行匹配(全能)
	 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
	 */
	@Pointcut(value = "execution( * com.zws.spring.service.*.*(..))")
	private void pointCutWithExecution() {
	}


	/**
	 * 参数匹配，只匹配参数，不管类及包。
	 */
	@Pointcut(value = "args(String, Integer)")
	private void pointCutWithArgs() {
	}


	/**
	 * 当方法的运行时入参对象标注了指定的注解(@ClassField)时，匹配切点。
	 * 例如：
	 *
	 * @ClassField public class UserInfo {...}
	 * <p>
	 * com.zws.spring.service.UserBService#printUserInfo(com.zws.spring.entity.UserInfo)
	 */
	@Pointcut(value = "@args(com.zws.spring.annotation.ClassField)")
	private void pointCutWithAnnoArgs() {
	}


	/**
	 * 根据包、接口、类名进行匹配，最小粒度为类。
	 */
	@Pointcut(value = "within(com.zws.spring.service.*)")
	private void pointCutUseWithin() {
	}


	/**
	 * 当前对象，也就是代理对象
	 * JDK代理的实现方式是基于接口实现，代理类继承Proxy，实现接口
	 * proxyTargetClass 如果设置为false的话，则采用JDK动态代理，这种方式就无法进行匹配到
	 * proxyTargetClass 如果设置为true的话，则是采用GCLB方式，是通过继承来实现，因此可以匹配到。
	 */
	@Pointcut("this(com.zws.spring.service.UserAService)")
	public void pointCutThis() {
	}


	/**
	 * 目标对象，也就是被代理的对象
	 * CGLIB继承被代理的类来实现, 所以使用target会保证目标不变，关联对象不会受到proxyTargetClass设置的影响。
	 */
	@Pointcut("target(com.zws.spring.service.UserAService)")
	public void pointCutTarget() {
	}

	/**
	 * 匹配目标对象，被该注解(@ClassField) 修饰的类
	 * 注意：Spring 不支持 @this方式匹配 【'@this' pointcut designator isn't supported by spring】
	 */
	@Pointcut("@target(com.zws.spring.annotation.ClassField)")
	private void pointCutWithAnnoTarget() {
	}

	/**
	 * 根据bean名称进行匹配，可支持通配符匹配。
	 */
	@Pointcut(value = "bean(*Service)")
	private void pointCutWithBean() {
	}


	@Before(value = "pointCutWithBean()")
	private void beforeAdvice() {
		System.out.println("############ before ############");
	}
}
