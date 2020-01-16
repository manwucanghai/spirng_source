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
@Aspect
@Component
public class AspectConfig {

	/**
	 * 测试采用@DeclareParents 为某个类(com.zws.spring.service.NotMethodService), 增强特定功能(IUserService)
	 */
	@DeclareParents(value = "com.zws.spring.service.NotMethodService", defaultImpl = UserAService.class)
	public static IUserService iUserService;

//	@Pointcut("execution(* com.zws.spring.service.NotMethodService(..))")
//	private void pointcut(){}

}
