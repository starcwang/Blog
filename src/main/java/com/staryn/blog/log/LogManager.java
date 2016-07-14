package com.staryn.blog.log;

/**
 * 日志管理类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 21:12:00
 */
public abstract class LogManager {
    private static final String DEFAULT_TRACE_ID = "0";
    private static final ThreadLocal<String> traceIdHolder = new ThreadLocal<>();
    private static final ThreadLocal<Long> reqTimeHolder = new ThreadLocal<>();

    /**
     * 初始化
     */
    public static void init() {
        reqTimeHolder.set(System.currentTimeMillis());
        traceIdHolder.set(null);
    }

    public static void setTraceId(String traceId) {
        traceIdHolder.set(traceId);
    }

    public static String getTraceId() {
        if (traceIdHolder.get() == null || traceIdHolder.get().length() == 0) {
            return DEFAULT_TRACE_ID;
        }
        return traceIdHolder.get();
    }

    public static long getReqProcessTime() {
        Long startTime = reqTimeHolder.get();
        if (startTime == null) {
            return 0L;
        }
        return System.currentTimeMillis() - startTime;
    }
}
