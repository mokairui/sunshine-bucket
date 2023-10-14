package com.sunshine.application.process;

import com.google.auto.service.AutoService;
import com.sunshine.application.process.context.ProcessContext;
import com.sunshine.service.generate.IGenerator;
import com.sunshine.service.generate.impl.DefaultGeneratorImpl;
import com.sunshine.service.generate.model.GeneratorContext;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/10
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.sunshine.Mapper"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MappingProcess extends AbstractProcessor {

    private ProcessContext processContext;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.processContext = new ProcessContext(processingEnv.getMessager(), processingEnv.getFiler(), processingEnv.getElementUtils(), processingEnv.getTypeUtils());
    }

    /**
     * 设置的入口是项目编译处设置
     *
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
            Set<? extends Element> annotationElements = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element annotationElement : annotationElements) {
                // 获取接口下所有的属性
                List<? extends Element> enclosedElements = annotationElement.getEnclosedElements();
                for (Element element : enclosedElements) {
                    if (element.getKind() == ElementKind.METHOD) {
                        // 获取元素被包裹的元素类型
                        Element enclosingElement = element.getEnclosingElement();
                        // 转为类的类型因为方法的包裹肯定是类元素, 通过类元素获取其全限定类名
                        String qualifiedName = ((TypeElement) enclosingElement).getQualifiedName().toString();
                        String packageName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
                        String className = qualifiedName.substring(qualifiedName.lastIndexOf(".") + 1, qualifiedName.length());

                        ExecutableElement executableElement = (ExecutableElement) element;
                        // 获取方法的返回类型
                        TypeMirror typeMirror = executableElement.getReturnType();
                        String methodName = executableElement.getSimpleName().toString();
                        // 获取方法的参数类型
                        List<? extends VariableElement> parameters = executableElement.getParameters();
                        List<String> paramQualifierNameList = new ArrayList<>(parameters.size());
                        List<String> importNameList = new ArrayList<>(parameters.size());
                        for (VariableElement parameter : parameters) {
                            // 获取参数的全限定类名
                            String paramQualifiedName = parameter.asType().toString();
                            importNameList.add(paramQualifiedName);
                            String paramName = paramQualifiedName.substring(paramQualifiedName.lastIndexOf(".") + 1, paramQualifiedName.length());
                            paramQualifierNameList.add(paramName);
                        }

                        GeneratorContext generatorContext = new GeneratorContext();
                        generatorContext.setPackageName(packageName);
                        generatorContext.setInterfaceName(className);
                        generatorContext.setReturnType(typeMirror.toString());
                        generatorContext.setFltName("clazzImpl.ftl");
                        generatorContext.setImportList(importNameList);
                        generatorContext.setParameters(paramQualifierNameList);
                        generatorContext.setMethodName(methodName);
                        IGenerator generator = new DefaultGeneratorImpl();
                        generator.generator(generatorContext, processContext);
                    }
                }
            }
        }

        return true;
    }

}
