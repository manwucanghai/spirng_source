package com.zws.spring;

import com.zws.spring.entity.TestBean;
import com.zws.spring.service.IUserService;
import com.zws.spring.service.NotMethodService;
import com.zws.spring.service.UserAService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhengws
 * @date 2020-01-12 20:08
 */

@ComponentScan(value = {"com.zws.spring"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(SpringApplication.class);
		ac.refresh();

//		aopDeclareParentsAnnotation(ac);

//		manualBeanRegister(ac);

		nomalAop(ac);

	}

	private static void nomalAop(AnnotationConfigApplicationContext ac) {
		IUserService userAService = (IUserService) ac.getBean("userBService");
		System.out.println(userAService.getName());

		System.out.println("#############################");
		IUserService userAService2 = (IUserService) ac.getBean("userBService");
		System.out.println(userAService2.getName());
	}

	/**
	 * 手动注册bean 测试
	 *
	 * @param ac
	 */
	private static void manualBeanRegister(AnnotationConfigApplicationContext ac) {
		ac.getBeanFactory().registerSingleton("testBean", new TestBean());
		System.out.println(ac.getBean(TestBean.class).name);
	}

	/**
	 * @param ac
	 * @DeclareParents 注解测试。 需开启AOP代理 @EnableAspectJAutoProxy
	 */
	private static void aopDeclareParentsAnnotation(AnnotationConfigApplicationContext ac) {
		System.out.println("###################");
		UserAService userAService = ac.getBean(UserAService.class);
		System.out.println(userAService.getName());


		System.out.println("++++++++++++++++++++");
		IUserService bean = (IUserService) ac.getBean(NotMethodService.class);
		System.out.println(bean.getName());

		/**
		 * 输出：
		 * UserAService 被实例化多次？？
		 * UserA Service constructor running ...
		 * 1600667055
		 * UserA Service constructor running ...
		 * UserB Service constructor running ...
		 * ###################
		 * UserA
		 * ++++++++++++++++++++
		 * 857068247
		 * UserA Service constructor running ...
		 * UserA
		 */
	}
}
