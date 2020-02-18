package com.zws.asm.test.visitor;

import com.zws.asm.test.InjectClazz;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;

/**
 * @author zhengws
 * @date 2020-02-18 16:54
 */
public class MethodVisitorAdapter extends MethodVisitor {

    private final String injectClass = InjectClazz.class.getName().replace(".","/");

    public MethodVisitorAdapter(MethodVisitor methodVisitor) {
        super(Opcodes.ASM7, methodVisitor);
    }

    @Override
    public void visitCode() {
        System.out.println("visitCode");
        this.visitMethodInsn(Opcodes.INVOKESTATIC, injectClass, "start", "()V", false);
        super.visitCode();
    }


    @Override
    public void visitInsn(int opcode) {
        System.out.println("visitInsn");
        this.visitMethodInsn(Opcodes.INVOKESTATIC, injectClass, "end","()V", false);
        super.visitInsn(opcode);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        System.out.println("visitMaxs");
        super.visitMaxs(maxStack, maxLocals);
    }
}
