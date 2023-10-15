package com.sunshine.service.generate.model;

import java.util.List;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/14
 */
public class ModelElement {
    private String interfaceName;
    private String packageName;
    private List<String> importList;
    private String className;
    private String methodName;
    private String returnType;
    private List<String> parameters;
    private String fltName;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<String> getImportList() {
        return importList;
    }

    public void setImportList(List<String> importList) {
        this.importList = importList;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getFltName() {
        return fltName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void setFltName(String fltName) {
        this.fltName = fltName;
    }
}
