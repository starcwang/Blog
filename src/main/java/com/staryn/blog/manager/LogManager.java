package com.staryn.blog.manager;

/**
 * 日志管理类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-13 21:12:00
 */
public abstract class LogManager {
    private static final String DEFAULT_TRACE_ID = "0";
    private static final String DEFAULT_URI = "/";
    private static final String DEFAULT_IP = "0.0.0.0";
    private static final ThreadLocal<String> traceIdHolder = new ThreadLocal<>();
    private static final ThreadLocal<Long> reqTimeHolder = new ThreadLocal<>();
    private static final ThreadLocal<String> uriHolder = new ThreadLocal<>();
    private static final ThreadLocal<String> ipHolder = new ThreadLocal<>();

    /**
     * 初始化
     */
    public static void init() {
        reqTimeHolder.set(System.currentTimeMillis());
        traceIdHolder.set(null);
        uriHolder.set(null);
        ipHolder.set(null);
    }

    public static void setTraceId(String traceId, String uri, String ip) {
        uriHolder.set(uri);
        traceIdHolder.set(traceId);
        ipHolder.set(ip);
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

    public static String getUri() {
        if (uriHolder.get() == null || uriHolder.get().length() == 0) {
            return DEFAULT_URI;
        }
        return uriHolder.get();
    }

    public static String getIp() {
        if (ipHolder.get() == null || ipHolder.get().length() == 0) {
            return DEFAULT_IP;
        }
        return ipHolder.get();
    }
}
