package com.sunshine.service.generate;

import com.sunshine.service.generate.model.ModelElement;
import com.sunshine.application.process.context.ProcessContext;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/14
 */
public interface IGenerator {
    
    void generator(ModelElement context, ProcessContext processContext);
    
}
