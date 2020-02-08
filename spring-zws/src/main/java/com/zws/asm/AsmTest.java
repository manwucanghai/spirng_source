package com.zws.asm;

import com.zws.asm.normal.NormalService;
import org.springframework.context.annotation.ConfigurationClassEnhancer;

/**
 * @author zhengws
 * @date 2020-02-04 12:10
 */
public class AsmTest {
    public static void main(String[] args) {
        ConfigurationClassEnhancer enhancer = new ConfigurationClassEnhancer();
        Class<?> clazz = enhancer.enhance(NormalService.class, AsmTest.class.getClassLoader());

        System.out.println(clazz);
    }
}
