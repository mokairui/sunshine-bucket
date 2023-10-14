package com.sunshine.service.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.IOException;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/14
 */
public class GeneratorConfig {

    private static final String ENCODING = "UTF-8";

    private static FreemarkerConfiguration freemarker = new FreemarkerConfiguration("/freemarker");

    public Template getTemplate(String ftl) throws IOException {
        return freemarker.getTemplate(ftl, ENCODING);
    }

    static class FreemarkerConfiguration extends Configuration {
        public FreemarkerConfiguration(String basePackagePath) {
            super(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            setDefaultEncoding(ENCODING);
            setClassForTemplateLoading(getClass(), basePackagePath);
        }
    }

}
