/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.util.Assert;

/**
 * A {@link ScopeMetadataResolver} implementation that by default checks for
 * the presence of Spring's {@link Scope @Scope} annotation on the bean class.
 *
 * <p>The exact type of annotation that is checked for is configurable via
 * {@link #setScopeAnnotationType(Class)}.
 *
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 2.5
 * @see org.springframework.context.annotation.Scope
 */
public class AnnotationScopeMetadataResolver implements ScopeMetadataResolver {

	private final ScopedProxyMode defaultProxyMode;

	protected Class<? extends Annotation> scopeAnnotationType = Scope.class;


	/**
	 * Construct a new {@code AnnotationScopeMetadataResolver}.
	 * @see #AnnotationScopeMetadataResolver(ScopedProxyMode)
	 * @see ScopedProxyMode#NO
	 */
	public AnnotationScopeMetadataResolver() {
		this.defaultProxyMode = ScopedProxyMode.NO;
	}

	/**
	 * Construct a new {@code AnnotationScopeMetadataResolver} using the
	 * supplied default {@link ScopedProxyMode}.
	 * @param defaultProxyMode the default scoped-proxy mode
	 */
	public AnnotationScopeMetadataResolver(ScopedProxyMode defaultProxyMode) {
		Assert.notNull(defaultProxyMode, "'defaultProxyMode' must not be null");
		this.defaultProxyMode = defaultProxyMode;
	}


	/**
	 * Set the type of annotation that is checked for by this
	 * {@code AnnotationScopeMetadataResolver}.
	 * @param scopeAnnotationType the target annotation type
	 */
	public void setScopeAnnotationType(Class<? extends Annotation> scopeAnnotationType) {
		Assert.notNull(scopeAnnotationType, "'scopeAnnotationType' must not be null");
		this.scopeAnnotationType = scopeAnnotationType;
	}


	/**
	 * 解析 BeanDefinition 的作用域
	 * 如果有配置 @Scope 则获取用户配置的值
	 * 如果没有，则默认的作用域为 singleton， proxyMode为 NO
	 * @param definition the target bean definition
	 * @return
	 */
	@Override
	public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
		ScopeMetadata metadata = new ScopeMetadata();
		if (definition instanceof AnnotatedBeanDefinition) {
			AnnotatedBeanDefinition annDef = (AnnotatedBeanDefinition) definition;
			/**
			 * 递归解析注解以及注解的父注解(排除Java自身注解) 和 metadata关联的class父类的所有注解及注解的父注解，
			 * 判断是否有包含 scopeAnnotationType，也就是@Scope的注解
			 * 如果有，则获取其注解相关内容
			 *
			 * 注意： AccessibleObject, Class, Constructor, Executable, Field, Method, Package, Parameter 这些类都实现了 AnnotatedElement 接口
			 * AnnotatedElement 该接口，是通过方式方式获取注解内容。
			 */
			AnnotationAttributes attributes = AnnotationConfigUtils.attributesFor(
					annDef.getMetadata(), this.scopeAnnotationType);
			if (attributes != null) {
				metadata.setScopeName(attributes.getString("value"));
				ScopedProxyMode proxyMode = attributes.getEnum("proxyMode");
				if (proxyMode == ScopedProxyMode.DEFAULT) {
					proxyMode = this.defaultProxyMode;
				}
				metadata.setScopedProxyMode(proxyMode);
			}
		}
		return metadata;
	}

}
