package com.zws.spring.controller;

import com.zws.spring.entity.BeanAdd;
import com.zws.spring.entity.TestNomalBeanImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengws
 * @date 2020-01-14 15:15
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

//	@Autowired
//	private BeanAdd beanAdd;

	@Autowired
	private TestNomalBeanImport testNomalBeanImport;


	@RequestMapping(value = "testStr")
	public String testStr() {
//		System.out.println(beanAdd.getName());
		System.out.println(testNomalBeanImport.getType());
		return "Hello World";
	}
}
