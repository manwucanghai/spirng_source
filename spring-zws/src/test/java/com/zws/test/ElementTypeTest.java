package com.zws.test;

import org.springframework.core.type.StandardAnnotationMetadata;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.GenericArrayType;

/**
 * @author zhengws
 * @date 2020-01-23 10:06
 */
public class ElementTypeTest {
	public static void main(String[] args) throws NoSuchMethodException {
		ClassFieldAnno anno = new ClassFieldAnno();

		StandardAnnotationMetadata sam = new StandardAnnotationMetadata(ClassFieldAnno.class);

		System.out.println(ClassFieldAnno.class.getMethod("print") instanceof AnnotatedElement);
	}
}
