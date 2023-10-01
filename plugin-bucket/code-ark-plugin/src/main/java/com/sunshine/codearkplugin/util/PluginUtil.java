package com.sunshine.codearkplugin.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.extensions.PluginId;

import java.io.File;
import java.util.List;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/1
 */
public class PluginUtil {

    private static final IdeaPluginDescriptor CODE_ARK_PLUGIN_DESCRIPTOR;
    
    static {
        PluginId id = PluginId.getId("com.sunshine.code-ark-plugin");
        CODE_ARK_PLUGIN_DESCRIPTOR = PluginManagerCore.getPlugin(id);
    }
    
    public static String getAgentCoreJarPath() {
        return getJarPathByStartWith("code-ark-core");
    }

    private static String getJarPathByStartWith(String startWith) {
        final String quotes = "\"";
        List<File> files = FileUtil.loopFiles(CODE_ARK_PLUGIN_DESCRIPTOR.getPluginPath().toFile());
        for (File file : files) {
            String name = file.getName();
            if (name.startsWith(startWith)) {
                String pathStr = FileUtil.getCanonicalPath(file);
                if (StrUtil.contains(pathStr, StrUtil.SPACE)) {
                    return StrUtil.builder().append(quotes).append(pathStr).append(quotes).toString();
                }
                return pathStr;
            }
        }
        return StrUtil.EMPTY;
    }
}
