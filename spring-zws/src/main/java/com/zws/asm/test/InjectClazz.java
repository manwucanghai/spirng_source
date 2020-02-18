package com.zws.asm.test;

/**
 * @author zhengws
 * @date 2020-02-17 13:58
 */
public class InjectClazz {
    public static void start(){
        System.out.println("StartTime: " + System.currentTimeMillis());
    }

    public static void end(){
        System.out.println("EndTime: " + System.currentTimeMillis());
    }
}