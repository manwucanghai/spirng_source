package com.zws.mybatis;

import com.zws.mybatis.config.AppConfig;
import com.zws.mybatis.mapper.CategoryMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhengws
 * @date 2020-01-29 22:29
 */
public class MybatisApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		CategoryMapper categoryMapper = ac.getBean(CategoryMapper.class);
		System.out.println(categoryMapper.query());
	}
}
