package com.sunshine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/2
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ApiAnnotation {
    
    String author() default "sunshine-mkr";
    String date();
    int version() default 1;
    
}
