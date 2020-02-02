package com.zws.mybatis.imports;

import com.zws.mybatis.mapper.CategoryMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhengws
 * @date 2020-02-02 10:34
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
//		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CategoryMapper.class);
//		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		/**
		 * 由于BeanClass的类型为MyFactoryBean.class 而不是具体实际类的类型，那如何获取代理对象？
		 * 在MyFactoryBean中提供 getObject 及 getObjectType 两个方法，让外部调用获取代理对象及对象接口类型。
		 *
		 * 由于MyFactoryBean 没有默认构造方法，因此需要往beanDefinition中添加指定构造方法的参数，在实例化对象时调用
		 *
		 * 设置 AutowireMode 为byType，可通过接口类型进行获取到bean对象。
		 */
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(CategoryMapper.class);
		beanDefinition.setBeanClass(MyFactoryBean.class);
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		registry.registerBeanDefinition("categoryMapper", beanDefinition);
	}
}
