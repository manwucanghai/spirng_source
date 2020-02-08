package com.zws.asm.descriptor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengws
 * @date 2020-02-03 22:05
 */
public class DescriptorTransform {
    /**
     * 提供Java原始类转换
     */
    private static final Map<String, String> transforms = new HashMap<>();

    static {
        transforms.put("void", "V");
        transforms.put("byte", "B");
        transforms.put("char", "C");
        transforms.put("double", "D");
        transforms.put("float", "F");
        transforms.put("int", "I");
        transforms.put("long", "J");
        transforms.put("short", "S");
        transforms.put("boolean", "Z");
    }

    private static String transform(String type) {
        if (type == null || "".equals(type)) {
            throw new NullPointerException();
        } else {
            String t = transforms.get(type);
            if (t != null) {
                return t;
            }
            StringBuilder sb = new StringBuilder();
            int index = 0;
            //解析一维或者多维数组
            while ((index = type.indexOf("[]", index) + 1) > 0) {
                sb.append('[');
            }

            type = type.substring(0, type.length() - sb.length() * 2);
            t = transforms.get(type);
            if (t != null) {
                sb.append(t);
            } else {
                sb.append('L').append(type.replace('.', '/')).append(';');
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(transform("int[]"));
        System.out.println(int[].class.getName().replace(".","/"));

        System.out.println("######################");
        System.out.println(transform("java.long.String[]"));
        System.out.println(String[].class.getName().replace(".","/"));

        System.out.println("######################");
        System.out.println(transform("char[]"));
        System.out.println(char[].class.getName().replace(".","/"));

        System.out.println("######################");
        System.out.println(transform(ClassLoader.class.getName()));

        /**
         * 输出：
         * [I
         * [I
         * ######################
         * [Ljava/long/String;
         * [Ljava/lang/String;
         * ######################
         * [C
         * [C
         * ######################
         * Ljava/lang/ClassLoader;
         */
    }
}
