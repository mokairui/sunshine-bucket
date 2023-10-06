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
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
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

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Abstract Process start!");
        Messager messager = processingEnv.getMessager();
        System.out.println("messager: " + messager);
        messager.printMessage(Diagnostic.Kind.NOTE, "Print: Hello World!");
        messager.printMessage(Diagnostic.Kind.WARNING, "Print: Hello World!");
        messager.printMessage(Diagnostic.Kind.NOTE, "Print: " + annotations);
        for (TypeElement typeElement : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.toString());
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.getSimpleName());
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.getEnclosedElements().toString());

                ApiAnnotation annotation = element.getAnnotation(ApiAnnotation.class);
            }
        }
        return false;
    }

}
