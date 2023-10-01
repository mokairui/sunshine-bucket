package com.sunshine.codearkplugin;

import com.intellij.execution.Executor;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.runners.JavaProgramPatcher;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/1
 */
public class PreJavaProgramPatch extends JavaProgramPatcher {
    @Override
    public void patchJavaParameters(Executor executor, RunProfile runProfile, JavaParameters javaParameters) {
        
    }
}
