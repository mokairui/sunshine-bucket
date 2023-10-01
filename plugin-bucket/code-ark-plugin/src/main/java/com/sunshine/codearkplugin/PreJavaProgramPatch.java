package com.sunshine.codearkplugin;

import cn.hutool.core.util.StrUtil;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.configurations.ParametersList;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.runners.JavaProgramPatcher;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.JavaSdkVersion;
import com.intellij.openapi.projectRoots.Sdk;
import com.sunshine.codearkplugin.util.PluginUtil;

import java.util.Objects;

/**
 * @author Mokairui
 * @description Java程序运行配置增强
 * @since 2023/10/1
 */
public class PreJavaProgramPatch extends JavaProgramPatcher {

    @Override
    public void patchJavaParameters(Executor executor, RunProfile runProfile, JavaParameters javaParameters) {
        if (!(runProfile instanceof RunConfiguration)) {
            return;
        }

        Sdk jdk = javaParameters.getJdk();
        if (Objects.isNull(jdk)) {
            return;
        }

        JavaSdkVersion version = JavaSdk.getInstance().getVersion(jdk);
        if (Objects.isNull(version)) {
            return;
        }
        
        if (version.compareTo(JavaSdkVersion.JDK_1_8) < 0) {
            return;
        }

        String agentCoreJarPath = PluginUtil.getAgentCoreJarPath();

        if (StrUtil.isBlank(agentCoreJarPath)) {
            return;
        }

        String mainClass = javaParameters.getMainClass();
        String packageName = mainClass.substring(0, mainClass.lastIndexOf("."));
        ParametersList vmParametersList = javaParameters.getVMParametersList();
        vmParametersList.addParametersString("-javaagent:" + agentCoreJarPath + "=" + packageName);
    }
    
}
