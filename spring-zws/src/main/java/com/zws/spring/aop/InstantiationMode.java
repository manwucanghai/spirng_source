package com.zws.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Instroduction mode 测试.
 * <p>
 * 最开始bean对象是单例，调整AOP切面模型，始终都没有效果，依然是单例，原因如下：
 * 这里面的前提是，bean 对象本身就是 prototype才有意义。
 * <p>
 * 说明：
 * 如果配置了 perthis,则该切面匹配的范围为  perthis中的切点范围 && 方法声名的切点范围的交集。
 * <p>
 * 配置方式：
 * 1. 在perthis 上指定该切面内部的Pointcut的方法
 * 2. 直接在perthis 中指定Pointcut表达式
 *
 * @author zhengws
 * @date 2020-01-17 06:55
 */
//@Component("instantiationMode")
//@Aspect("perthis(this(com.zws.spring.service.UserAService))")
@Aspect("perthis(com.zws.spring.aop.InstantiationMode.pointcut())")  //这里是指定切面.
@Scope("prototype")
public class InstantiationMode {

	@Pointcut("execution(* com.zws.spring.service.*.*(..))")
	private void pointcut() {
	}

	@Before(value = "pointcut()")
	public void before() {
		System.out.println(this.hashCode());
		System.out.println(this);
		System.out.println("=============before=============");
	}

	/**
	 * 配置信息为如下时：
	 * @Aspect("perthis(com.zws.spring.aop.InstantiationMode.pointcut())")  //这里是指定切面.
	 * @Scope("prototype")
	 *
	 * 输出：
	 * UserB Service constructor running ...
	 * 1498438472
	 * com.zws.spring.aop.InstantiationMode@59505b48
	 * =============before=============
	 * B Name
	 * #############################
	 * UserB Service constructor running ...
	 * 806511723
	 * com.zws.spring.aop.InstantiationMode@3012646b
	 * =============before=============
	 * B Name
	 *
	 *
	 *
	 * 配置信息为如下时：
	 * @Aspect
	 *
	 * 这里切面的对象是同一个，也就是bean原型，如果使用到切面中的变量，则存在安全问题。
	 *
	 * 输出：
	 * UserB Service constructor running ...
	 * 829149076
	 * com.zws.spring.aop.InstantiationMode@316bcf94
	 * =============before=============
	 * B Name
	 * #############################
	 * UserB Service constructor running ...
	 * 829149076
	 * com.zws.spring.aop.InstantiationMode@316bcf94
	 * =============before=============
	 * B Name
	 */
}
