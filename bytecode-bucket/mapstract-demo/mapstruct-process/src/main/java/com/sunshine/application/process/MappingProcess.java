package com.sunshine.application.process;

import com.google.auto.service.AutoService;
import com.sunshine.application.process.context.ProcessContext;
import com.sunshine.service.generate.IGenerator;
import com.sunshine.service.generate.impl.DefaultGeneratorImpl;
import com.sunshine.service.generate.model.ModelElement;
import com.sunshine.service.processor.ModelElementProcessor;

import javax.annotation.processing.AbstractProcessor;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
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

            Object model = null;

            // 取出所有注解修饰的类, @Mapper 限制了只能标注在类上, 那么elements就都是类的类型了
            Set<? extends Element> annotationElements = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element annotationElement : annotationElements) {
                Iterable<ModelElementProcessor<?, ?>> processors = getProcessors();
                for (ModelElementProcessor<?, ?> processor : processors) {
                    model = process(processor, processContext, annotationElement, model);
                }
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    private <P, R> R process(ModelElementProcessor<P, R> processor, ProcessContext processContext, Element annotationElement, Object model) {
        P sourceModel = (P) model;
        return processor.process(processContext, annotationElement, sourceModel);
    }

    @SuppressWarnings("all")
    private Iterable<ModelElementProcessor<?, ?>> getProcessors() {
        Iterator<ModelElementProcessor> iterator = ServiceLoader.load(
                ModelElementProcessor.class, 
                MappingProcess.class.getClassLoader()
        ).iterator();
        
        List<ModelElementProcessor<?, ?>> processors = new ArrayList<>();
        while (iterator.hasNext()) {
            processors.add(iterator.next());
        }
        
        processors.sort(new ProcessorComparator());
        return processors;
    }

    private static class ProcessorComparator implements Comparator<ModelElementProcessor<?, ?>> {
        @Override
        public int compare(ModelElementProcessor<?, ?> o1, ModelElementProcessor<?, ?> o2) {
            return Integer.compare(o2.getPriority(), o1.getPriority());
        }
    }
}
