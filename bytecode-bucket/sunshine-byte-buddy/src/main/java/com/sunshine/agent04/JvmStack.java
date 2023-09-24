package com.sunshine.agent04;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/24
 */
public class JvmStack {

    private static final long MB = 1048576L;

    static void printMemoryInfo() {
        System.out.println("开始收集内存信息!");
        MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
        MemoryUsage headMemory = memory.getHeapMemoryUsage();

        // 获取堆内存信息
        String memoryInfo = MessageFormat.format("init: {0}\t max: {1}MB\t used: {2}MB\t committed: {3}MB\t use rate: {4}",
                headMemory.getInit() / MB,
                headMemory.getMax() / MB,
                headMemory.getUsed() / MB,
                headMemory.getCommitted() / MB,
                headMemory.getUsed() * 100 / headMemory.getCommitted());

        System.out.println(memoryInfo);

        MemoryUsage nonHeadMemory = memory.getNonHeapMemoryUsage();

        // 获取堆外内存信息
        memoryInfo = MessageFormat.format("init: {0}\t max: {1}MB\t used: {2}MB\t committed: {3}MB\t use rate: {4}",
                nonHeadMemory.getInit() / MB,
                nonHeadMemory.getMax() / MB,
                nonHeadMemory.getUsed() / MB,
                nonHeadMemory.getCommitted() / MB,
                nonHeadMemory.getUsed() * 100 / nonHeadMemory.getCommitted());
        System.out.println(memoryInfo);
    }

    static void printGCInfo() {
        List<GarbageCollectorMXBean> garbages = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbage : garbages) {
            String info = String.format("name: %s\t count: %s\t took: %s\t pool name: %s",
                    garbage.getName(),
                    garbage.getCollectionCount(),
                    garbage.getCollectionTime(),
                    Arrays.deepToString(garbage.getMemoryPoolNames()));
            System.out.println(info);
        }
    }

}
