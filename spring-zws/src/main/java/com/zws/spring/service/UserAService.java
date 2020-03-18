package com.zws.spring.service;

import com.zws.spring.annotation.ClassField;
import com.zws.spring.entity.BeanAdd;
import com.zws.spring.entity.TestNomalBeanImport;
import com.zws.spring.imports.MyImportBeanDefinitionRegistrar;
import com.zws.spring.imports.MyImportSelector;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zhengws
 * @date 2020-01-12 20:25
 */

/**
 * @Import 也是可以在任意被Spring容器加载的类进行使用
 */
@Import(value = {MyImportBeanDefinitionRegistrar.class, TestNomalBeanImport.class, MyImportSelector.class})
@Service(value = "userAService")
//@Component(value = "userAService")
//@Scope("prototype")
//@DependsOn(value = {"userBService"})
@ClassField
public class UserAService implements IUserService, InitializingBean {
	@Autowired
	/**
	 * 加了@Lazy注解后，获取到的userBService 与容器中的userBService其实不是同一个实例，而是代理类实例.
	 * org.springframework.beans.factory.support.AutowireCandidateResolver#getLazyResolutionProxyIfNecessary()
	 */
//	@Lazy
	public IUserService userBService;

//	@Autowired
//	public AService aService;

//	@ConstructorProperties(value = {"userBService"})
	// 可采用@Autowired或者@Inject选择特定的构造方法进行注入，多个构造方法只能添加一个@Autowired注解.
//	@Autowired
////	@Inject
//	public UserAService(UserBService userBService){
//		this.userBService = userBService;
//	}

//	@Autowired
//	public UserAService(UserBService userBService, AService aService){
//		System.out.println("ccccccc");
//	}
	private String name = "UserA";

//	public UserAService() {
//		System.out.println(this.hashCode());
//		System.out.println("UserA Service constructor running ...");
//	}

//	/**
//	 * @Bean是可以在任意的被注册到spring容器中使用。 这个跟AOP一起使用会存在问题。
//	 * @return
//	 */
//	@Bean
//	public BeanAdd beanAdd(){
//		return new BeanAdd();
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
		this.name = "afterPropertiesSet";
	}
}
