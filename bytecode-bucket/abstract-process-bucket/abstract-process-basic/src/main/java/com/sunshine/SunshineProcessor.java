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
 * @description
 * @since 2023/10/2
 */
@SupportedAnnotationTypes({"com.sunshine.annotation.ApiAnnotation"})
//@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class SunshineProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("123");
        Messager messager = processingEnv.getMessager();
        for (TypeElement typeElement : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.toString());
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.getSimpleName());
                messager.printMessage(Diagnostic.Kind.WARNING, "Print: " + element.getEnclosedElements().toString());

                ApiAnnotation annotation = element.getAnnotation(ApiAnnotation.class);
            }
        }
        System.out.println("Abstract Processor!");
        return true;
    }
    
    

}
