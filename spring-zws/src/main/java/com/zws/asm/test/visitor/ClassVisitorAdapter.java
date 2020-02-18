package com.zws.asm.test.visitor;

import org.springframework.asm.ClassVisitor;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;

/**
 * @author zhengws
 * @date 2020-02-18 16:53
 */
public class ClassVisitorAdapter extends ClassVisitor {

    public ClassVisitorAdapter(ClassVisitor classVisitor) {
        super(Opcodes.ASM7, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (name.equals("process")){
            return new MethodVisitorAdapter(methodVisitor);
        }
        return methodVisitor;
    }
}
