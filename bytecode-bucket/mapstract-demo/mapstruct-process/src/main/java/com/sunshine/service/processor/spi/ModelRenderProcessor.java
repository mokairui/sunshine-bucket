package com.sunshine.service.processor.spi;

import com.sunshine.application.process.context.ProcessContext;
import com.sunshine.service.processor.generate.IGenerator;
import com.sunshine.service.processor.generate.impl.DefaultGeneratorImpl;
import com.sunshine.service.processor.model.ModelElement;
import com.sunshine.service.processor.ModelElementProcessor;

import javax.lang.model.element.Element;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/15
 */
public class ModelRenderProcessor implements ModelElementProcessor<ModelElement, Void> {
    
    private final IGenerator generator = new DefaultGeneratorImpl();
    
    @Override
    public Void process(ProcessContext processContext, Element annotationElement, ModelElement sourceModel) {
        generator.generator(sourceModel, processContext);
        return null;
    }

    @Override
    public int getPriority() {
        return Integer.MIN_VALUE;
    }
}
