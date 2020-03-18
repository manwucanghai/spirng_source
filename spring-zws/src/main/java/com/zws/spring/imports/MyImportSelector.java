package com.zws.spring.imports;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhengws
 * @date 2020-03-17 17:47
 */
public class MyImportSelector implements ImportSelector , EnvironmentAware {
    private Environment environment;
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyImportSelector selectImports running ...");
        return new String[0];
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("MyImportSelector set Environment ");
        this.environment = environment;
    }
}
