module com.sunshine.SunshineProcessorModule {
    requires java.compiler;
    requires jdk.compiler;
    requires com.google.auto.service;

    exports com.sunshine; // 导出 com.sunshine 包作为模块的 API
}