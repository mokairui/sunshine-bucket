package com.sunshine;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Mapper {
}
