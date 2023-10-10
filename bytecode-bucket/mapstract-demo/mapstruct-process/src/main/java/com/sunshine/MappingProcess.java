package com.sunshine;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/10
 */
@AutoService(MappingProcess.class)
@SupportedAnnotationTypes({})
public class MappingProcess extends AbstractProcessor {
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        
        
        return false;
    }
    
}
