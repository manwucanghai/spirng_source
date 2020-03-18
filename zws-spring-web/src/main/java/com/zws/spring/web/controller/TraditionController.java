package com.zws.spring.web.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhengws
 * @date 2020-02-22 20:42
 *
 * 注意，此处注解必须加/开头,才会进行匹配到。
 */
@Component(value = "/tradition")
public class TraditionController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("TraditionController handleRequest");
        return null;
    }
}
