package com.zws.spring;

import com.zws.spring.entity.TestBean;
import com.zws.spring.entity.UserInfo;
import com.zws.spring.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhengws
 * @date 2020-01-12 20:08
 */

@ComponentScan(value = {"com.zws.spring"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@ImportResource(value = {"classpath:spring.xml"})
public class SpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(SpringApplication.class);
		ac.refresh();

//		aopDeclareParentsAnnotation(ac);

//		manualBeanRegister(ac);

		normalAop(ac);


	}

	private static void normalAop(AnnotationConfigApplicationContext ac) {
//		Object bean = ac.getBean("userAService");
//		Class<?>[] interfaces = bean.getClass().getInterfaces();
//		for (int i = 0; i < interfaces.length; i++) {
//			System.out.println(interfaces[i]);
//
//		}
//		System.out.println(bean);
		UserAService userAService = ac.getBean(UserAService.class);
		userAService.userBService.setName("userAService depends");
		UserBService userBService = ac.getBean(UserBService.class);
		System.out.println(userAService.userBService.getName());
		System.out.println(userBService.getName());
		System.out.println(userAService.userBService.hashCode());
		System.out.println(userBService.hashCode());

		userBService.setName("UserB");
		System.out.println(userAService.userBService.getName());
		System.out.println(userBService.getName());
//		IUserService userAService = (IUserService) ac.getBean("userAService");
//		System.out.println(userAService.getName());
//		System.out.println(userAService.service);

//		AService aService = (AService) ac.getBean("aService");
//		aService.printService();
//		aService.printService();


//		System.out.println("#############################");
//		UserBService userB = ac.getBean(UserBService.class);
//		userB.printMessage("UserB printMessage");
//		userB.printMessageWithAge("UserB printMessageWithAge ", 20);
//		userB.printUserInfo(new UserInfo("zws",29));
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
