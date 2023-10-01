package com.sunshine.codearkplugin;

import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.BeforeRunTaskProvider;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/1
 */
public class PreBeforeRunTaskProvider extends BeforeRunTaskProvider {
    @Override
    public Key getId() {
        return new Key("code-ark-plugin");
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getName() {
        return "Code-Ark-Plugin";
    }

    @Nullable
    @Override
    public BeforeRunTask<?> createTask(@NotNull RunConfiguration runConfiguration) {
        return null;
    }

    @Override
    public boolean executeTask(@NotNull DataContext dataContext, @NotNull RunConfiguration runConfiguration, @NotNull ExecutionEnvironment executionEnvironment, @NotNull BeforeRunTask beforeRunTask) {
        return false;
    }

//    @Override
//    protected RunContentDescriptor doExecute(@NotNull RunProfileState state, @NotNull ExecutionEnvironment env) throws ExecutionException {
//        System.out.println("进来了插件配置: doExecute");
//        JavaParameters parameters = ((JavaCommandLine) state).getJavaParameters();
//        // 信息获取
//        PsiFile psiFile = env.getDataContext().getData(LangDataKeys.PSI_FILE);
//        String packageName = ((PsiJavaFileImpl) psiFile).getPackageName();
//        // 添加字节码插装
//        ParametersList parametersList = parameters.getVMParametersList();
//        parametersList.add("-javaagent:" + this.getClass().getResource("/").getPath().substring(1) + "code-ark-core.jar=" + packageName);
//        return super.doExecute(state, env);
//    }
}
