package com.sunshine;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.List;
import java.util.Set;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/10
 */
@AutoService(MappingProcess.class)
@SupportedAnnotationTypes({"com.sunshine.Mapper"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MappingProcess extends AbstractProcessor {

    private Messager messager;
    private Filer filer;
    private Elements elementUtils;
    private Types typeUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
        filer = processingEnv.getFiler();
        elementUtils = processingEnv.getElementUtils();
        typeUtils = processingEnv.getTypeUtils();
    }

    /**
     * 设置的入口是项目编译处设置
     * @return 返回此 Processor 可以处理的注解操作, 现在提供了对应的注解 @SupportedOptions()
     */
    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement typeElement : annotations) {
            if (typeElement.getKind() != ElementKind.ANNOTATION_TYPE) {
                continue;
            }
            
            // 取出所有注解修饰的类, @Mapper 限制了只能标注在类上, 那么elements就都是类的类型了
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element element : elements) {
                // 获取接口下所有的属性
                List<? extends Element> enclosedElements = element.getEnclosedElements();
                for (Element interfaceElement : enclosedElements) {
                    if (interfaceElement.getKind() == ElementKind.FIELD) {
                        
                    }
                    if (interfaceElement.getKind() == ElementKind.METHOD) {
                        
                    }
                }
            }
        }
        
        return false;
    }
    
}
