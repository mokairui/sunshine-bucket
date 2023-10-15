package com.sunshine.service.processor.spi;

import com.sunshine.application.process.context.ProcessContext;
import com.sunshine.service.processor.model.ModelElement;
import com.sunshine.service.processor.ModelElementProcessor;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/15
 */
public class ModelCreatedProcessor implements ModelElementProcessor<Void, ModelElement> {


    @Override
    public ModelElement process(ProcessContext context, Element element, Void sourceModel) {
        // 获取接口下所有的属性
        List<? extends Element> enclosedElements = element.getEnclosedElements();
        for (Element subElement : enclosedElements) {
            if (subElement.getKind() == ElementKind.METHOD) {
                // 获取元素被包裹的元素类型
                Element enclosingElement = subElement.getEnclosingElement();
                // 转为类的类型因为方法的包裹肯定是类元素, 通过类元素获取其全限定类名
                String qualifiedName = ((TypeElement) enclosingElement).getQualifiedName().toString();
                String packageName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
                String className = qualifiedName.substring(qualifiedName.lastIndexOf(".") + 1, qualifiedName.length());

                ExecutableElement executableElement = (ExecutableElement) subElement;
                // 获取方法的返回类型
                String returnTypeQualifiedName = executableElement.getReturnType().toString();
                String returnType = returnTypeQualifiedName.substring(returnTypeQualifiedName.lastIndexOf(".") + 1, returnTypeQualifiedName.length());
                // 获取方法名称
                String methodName = executableElement.getSimpleName().toString();
                // 获取方法的参数类型
                List<? extends VariableElement> parameters = executableElement.getParameters();
                List<String> paramQualifierNameList = new ArrayList<>(parameters.size());
                List<String> importNameList = new ArrayList<>(parameters.size() + 1);
                importNameList.add(returnTypeQualifiedName);
                for (VariableElement parameter : parameters) {
                    // 获取参数的全限定类名
                    String paramQualifiedName = parameter.asType().toString();
                    importNameList.add(paramQualifiedName);
                    String paramName = paramQualifiedName.substring(paramQualifiedName.lastIndexOf(".") + 1, paramQualifiedName.length());
                    paramQualifierNameList.add(paramName);
                }

                ModelElement modelElement = new ModelElement();
                modelElement.setPackageName(packageName);
                modelElement.setInterfaceName(className);
                modelElement.setReturnType(returnType);
                modelElement.setFltName("clazzImpl.ftl");
                modelElement.setImportList(importNameList);
                modelElement.setParameters(paramQualifierNameList);
                modelElement.setMethodName(methodName);
                // TODO 多个方法映射, 目前只处理一个方法
                return modelElement;
            }
        }
        return null;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }
}
