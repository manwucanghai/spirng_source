package com.zws.mybatis;

import com.zws.mybatis.config.AppConfig;
import com.zws.mybatis.mapper.CategoryMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengws
 * @date 2020-01-29 22:29
 */
public class MybatisApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();

		Object mapper = ac.getBean("categoryMapper");
		System.out.println(mapper);
//		CategoryMapper categoryMapper = ac.getBean(CategoryMapper.class);
//		System.out.println(categoryMapper.query());
//		Set<Integer> s = new HashSet<>();
//		s.add(4);
//		s.add(9);
//		System.out.println(categoryMapper.queryWithImageId(s));
	}
}
