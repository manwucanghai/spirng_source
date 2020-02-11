package com.zws.spring.initializer;

import com.zws.spring.service.AService;
import com.zws.spring.service.IUserService;
import com.zws.spring.service.UserBService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author zhengws
 * @date 2020-02-11 11:55
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("userAService")){
            IUserService service = new UserBService();
            try {
                Constructor<?> constructor = beanClass.getDeclaredConstructor(IUserService.class);
                return constructor.newInstance(service);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }
}
