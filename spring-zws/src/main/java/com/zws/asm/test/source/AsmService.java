package com.zws.asm.test.source;

import java.io.IOException;

/**
 * @author zhengws
 * @date 2020-02-18 17:01
 */
public class AsmService {
    private static final String name = "zws";

    public void process() {
        System.out.println("process....");
    }

    public void handle() throws IOException {
        System.out.println("handle ....");
    }
}
