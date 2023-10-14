package com.sunshine.service.generate;

import com.sunshine.service.generate.model.GeneratorContext;
import com.sunshine.application.process.context.ProcessContext;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/14
 */
public abstract class AbstractGenerator extends GeneratorConfig implements IGenerator {

    @Override
    public void generator(GeneratorContext context, ProcessContext processContext) {
        generatorSourceFile(context, processContext);
    }

    protected abstract void generatorSourceFile(GeneratorContext context, ProcessContext processContext);
    
    protected void writeSourceFile(String ftl, Writer writer, Object dataMap) {
        try {
            Template template = super.getTemplate(ftl);
            template.process(dataMap, writer);
            writer.flush();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException("generate source file failed, not found template!");
        }
    }

}
