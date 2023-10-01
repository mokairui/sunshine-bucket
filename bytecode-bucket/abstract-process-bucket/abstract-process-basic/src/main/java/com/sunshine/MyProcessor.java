package com.sunshine;

import com.sunshine.annotation.ApiAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
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
public class MyProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
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
