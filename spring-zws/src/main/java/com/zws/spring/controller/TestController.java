package com.zws.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengws
 * @date 2020-01-14 15:15
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "testStr")
	public String testStr() {
		return "Hello World";
	}
}
