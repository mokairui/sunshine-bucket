package com.sunshine.service.processor;

import com.sunshine.application.process.context.ProcessContext;

import javax.lang.model.element.Element;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/15
 */
public interface ModelElementProcessor<P, R> {
    R process(ProcessContext context, Element annotationElement, P p);
    int getPriority();
}
