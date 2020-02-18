package com.zws.spring.process.modifybd;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;

import java.util.Properties;

/**
 * @author zhengws
 * @date 2020-02-12 21:17
 */
public class MyPropertyResourceConfigurer extends PropertyResourceConfigurer {
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {

    }
}
