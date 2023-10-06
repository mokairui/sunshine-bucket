package com.sunshine;

import com.google.auto.service.AutoService;
import com.sunshine.annotation.ApiAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Set;

/**
 * @author Mokairui
 * @description jdk1.8 的 AbstractProcessor 注解解释器使用
 * @since 2023/10/2
 */
@SupportedAnnotationTypes({"com.sunshine.annotation.ApiAnnotation"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class SunshineProcessor extends AbstractProcessor {
    
    public static final String SUFFIX = "AutoGenerate";
    
    public static final String PREFIX = "My_";

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (TypeElement typeElement : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.toString());
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.getSimpleName());
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.getEnclosedElements().toString());

                // 获取注解
                ApiAnnotation annotation = element.getAnnotation(ApiAnnotation.class);
                // 获取元素名并将首字母大写
                String name = element.getSimpleName().toString();
                char upperNameFirstC = Character.toUpperCase(name.charAt(0));
                name = upperNameFirstC + name.substring(1);
                // 包裹注解元素的元素, 也就是父元素, 比如注解了成员变量或则成员函数, 其上层就是该类
                Element enclosingElement = element.getEnclosingElement();
                // 获取父元素的全类名, 用来生成包名
                String enclosingQualifiedName;
                if (enclosingElement instanceof PackageElement) {
                    enclosingQualifiedName = ((PackageElement) enclosingElement).getQualifiedName().toString();
                } else {
                    enclosingQualifiedName = ((TypeElement) enclosingElement).getQualifiedName().toString();
                }

                try {
                    // 生成包名
                    String generatorPacketName = enclosingQualifiedName.substring(0, enclosingQualifiedName.lastIndexOf("."));
                    // 生成类名
                    String generateClassName = PREFIX + enclosingElement.getSimpleName() + SUFFIX;
                    // 创建 java 文件
                    JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(generateClassName);
                    // 在控制台输出文件路径
                    System.out.println(sourceFile.toUri());
                    messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " + sourceFile.toUri());

                    try (Writer writer = sourceFile.openWriter()) {
                        PrintWriter pw = new PrintWriter(writer);
                        pw.println("package " + generatorPacketName + ";");
                        pw.println("\npublic class " + generateClassName + " {");
                        pw.println("\n /** 打印内容 */");
                        pw.println("\n public static void print() {");
                        pw.println(" // 注解的父元素: " + enclosingElement);
                        pw.println(" System.out.println(\"代码生成的路径: " + sourceFile.toUri() + "\");");
                        pw.println(" System.out.println(\"注解的元素: " + element + "\");");
                        pw.println(" System.out.println(\"注解的版本: " + annotation.version() + "\");");
                        pw.println(" System.out.println(\"注解的作者: " + annotation.author() + "\");");
                        pw.println(" System.out.println(\"注解的日期: " + annotation.date() + "\");");
                        pw.println("}");
                        pw.println("}");
                        pw.flush();
                    }
                    
                } catch (IOException e) {
                    messager.printMessage(Diagnostic.Kind.ERROR, e.getMessage());
                }
            }
        }
        return false;
    }

}
