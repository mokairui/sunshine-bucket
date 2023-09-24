package com.sunshine.agent04;

import java.lang.instrument.Instrumentation;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/24
 */
public class MyAgent {
   
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is agent04: " + agentArgs);

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            System.out.println("定时任务收集内存, GC等信息!");
            JvmStack.printMemoryInfo();
            JvmStack.printGCInfo();
        }, 0, 10, TimeUnit.SECONDS);
    }
    
}
