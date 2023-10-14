package com.sunshine.application.process.context;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/14
 */
public class ProcessContext {
    private Messager messager;
    private Filer filer;
    private Elements elementUtils;
    private Types typeUtils;

    public ProcessContext(Messager messager, Filer filer, Elements elementUtils, Types typeUtils) {
        this.messager = messager;
        this.filer = filer;
        this.elementUtils = elementUtils;
        this.typeUtils = typeUtils;
    }

    public Messager getMessager() {
        return messager;
    }

    public void setMessager(Messager messager) {
        this.messager = messager;
    }

    public Filer getFiler() {
        return filer;
    }

    public void setFiler(Filer filer) {
        this.filer = filer;
    }

    public Elements getElementUtils() {
        return elementUtils;
    }

    public void setElementUtils(Elements elementUtils) {
        this.elementUtils = elementUtils;
    }

    public Types getTypeUtils() {
        return typeUtils;
    }

    public void setTypeUtils(Types typeUtils) {
        this.typeUtils = typeUtils;
    }
}
