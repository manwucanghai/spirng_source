package com.zws.asm.test;

import com.zws.asm.test.classloader.CustomClassLoader;
import com.zws.asm.test.visitor.ClassVisitorAdapter;
import org.springframework.asm.ClassReader;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/**
 * @author zhengws
 * @date 2020-02-18 16:57
 */
public class AsmTest {
    public static void main(String[] args) throws Exception{
        /**
         * 1.创建ClassReader实例
         * 2.完成字节码文件读取，转换成byte[]，存放到classFileBuffer中.
         * 3.进行Java版本校验
         * 4.获取常量池中各个常量的索引位置，并保持到cpInfoOffsets中。
         */
        ClassReader classReader = new ClassReader("com.zws.asm.test.source.AsmService");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor classVisitor = new ClassVisitorAdapter(classWriter);
        classReader.accept(classVisitor,0);

        byte[] bytes = classWriter.toByteArray();

        FileOutputStream outputStream = new FileOutputStream(new File("/Users/zhengws/Desktop/com/zws/asm/test/source/AsmService.class"));
        outputStream.write(bytes);

        outputStream.close();

        CustomClassLoader classLoader = new CustomClassLoader(null,"loader1");
        classLoader.setPath("/Users/zhengws/Desktop/");
        Class<?> clazz = classLoader.loadClass("com.zws.asm.test.source.AsmService");

        System.out.println(clazz);

        Object instance = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("process");
        method.invoke(instance);
    }
}
