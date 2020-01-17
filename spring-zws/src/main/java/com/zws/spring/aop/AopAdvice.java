package com.zws.spring.aop;

import com.zws.spring.entity.UserInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhengws
 * @date 2020-01-17 17:36
 */
@Aspect
@Component
public class AopAdvice {

	@Pointcut(value = "execution( * com.zws.spring.service.*.*(..))")
	private void pointcut() {
	}

	/**
	 * 执行方法之前
	 */
	@Before(value = "pointcut()")
	@Order(10) //无效果
	private void beforeAdvice(){
		System.out.println("--------- before1 advice ----------");
	}


	/**
	 * 执行方法之前
	 */
	@Before(value = "pointcut()")
	@Order(1) //无效果
	private void beforeAdvice2(){
		System.out.println("--------- before2 advice ----------");
	}

//	/**
//	 * 执行方法之后，且一定会被执行，相当于 try{} finnaly{...}
//	 */
//	@After(value = "pointcut()")
//	private void afterAdvice(){
//		System.out.println("---------- after advice -----------");
//	}

//	/**
//	 * 代码正常返回时，会调用通知，如果异常，则不进行处理。
//	 */
//	@AfterReturning(value = "pointcut()")
//	private void afterReturnAdvice(){
//		System.out.println("---------- after return advice -----------");
//	}

//	/**
//	 * 环绕注解在方法执行前后进行注入，此时就可灵活控制异常后是否执行后置处理。
//	 * @param pjp
//	 * @return
//	 */
//	@Around(value = "pointcut()")
//	private Object aroundAdvice(ProceedingJoinPoint pjp) {
//		System.out.println("执行方法之前");
//		/**
//		 * 获取方法参数，进行修改。
//		 */
//		Object[] args = modifyArgs(pjp);
//		Object result = null;
//		try {
//			result = pjp.proceed(args);
//		} catch (Throwable throwable) {
//			throwable.printStackTrace();
//		}
//		System.out.println("执行方法之后");
//		return result;
//	}
//
//	/**
//	 * 可对参数进行修改后，再传入。
//	 * @param pjp
//	 * @return
//	 */
//	private Object[] modifyArgs(ProceedingJoinPoint pjp) {
//		Object[] args = pjp.getArgs();
//		for (int i = 0; i < args.length ; i++) {
//			Object arg = args[i];
//			if (arg instanceof UserInfo){
//				((UserInfo) arg).name = "zhengws";
//			}
//		}
//		return args;
//	}

}
