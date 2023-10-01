package com.sunshine.codearkplugin;

import cn.hutool.core.util.StrUtil;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.RunConfigurationExtension;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.configurations.ParametersList;
import com.intellij.execution.configurations.RunConfigurationBase;
import com.intellij.execution.configurations.RunnerSettings;
import com.sunshine.codearkplugin.util.PluginUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Mokairui
 * @description 运行配置扩展, 每次点击执行的时候都会进入, 是否执行到具体的操作步骤由 isApplicableFor 来决定
 * @since 2023/10/1
 */
public class PreRunConfigExtension extends RunConfigurationExtension {
    
    @Override
    public <T extends RunConfigurationBase<?>> void updateJavaParameters(@NotNull T t, @NotNull JavaParameters javaParameters, @Nullable RunnerSettings runnerSettings) throws ExecutionException {
        String agentCoreJarPath = PluginUtil.getAgentCoreJarPath();
        if (StrUtil.isBlank(agentCoreJarPath)) {
            return;
        }

        String mainClass = javaParameters.getMainClass();
        String packageName = mainClass.substring(0, mainClass.lastIndexOf("."));
        ParametersList vmParametersList = javaParameters.getVMParametersList();
        vmParametersList.addParametersString("-javaagent:" + agentCoreJarPath + "=" + packageName);
        System.out.println(javaParameters.getVMParametersList());
    }

    
    
    @Override
    public boolean isApplicableFor(@NotNull RunConfigurationBase<?> runConfigurationBase) {
        // 检查该扩展是否适用于给定的配置类型
        if (runConfigurationBase.getType().getId().equals("Application")) {
            return true;
        }

        // 或检查配置的名称后缀
        String name = runConfigurationBase.getName();
        return name.endsWith(".java");
    }
}
