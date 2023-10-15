package com.sunshine.service.generate.impl;

import com.sunshine.service.generate.AbstractGenerator;
import com.sunshine.service.generate.model.ModelElement;
import com.sunshine.application.process.context.ProcessContext;

import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/14
 */
public class DefaultGeneratorImpl extends AbstractGenerator {
    
    private static final String PREFIX = "MySelf";
    private static final String SUFFIX = "_Impl";
    
    @Override
    protected void generatorSourceFile(ModelElement context, ProcessContext processContext) {
        context.setClassName(PREFIX + context.getInterfaceName() + SUFFIX);
        try {
            JavaFileObject sourceFile = processContext.getFiler().createSourceFile(context.getClassName());
            /*
                重要: 记得一定要关闭流, 否则生成的java文件并不会编译为.class文件, 因为没有关闭流, 那么生成的java文件还处于没有完成的状态
                进而导致编译器无法将其转为有效的.class文件
             */
            try (Writer writer = sourceFile.openWriter()) {
                writeSourceFile(context.getFltName(), writer, context);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
