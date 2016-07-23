package com.staryn.blog.util;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.staryn.blog.manager.LogManager;

/**
 * 日志打印通用类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-14 16:19:00
 */
public abstract class UnifyLogger {
    private static final String FIELD_BEGIN = "[";
    private static final String FIELD_END = "]";
    private static final String FIELD_SEPARATOR = "######";
    private static final String LOG_FILE_NAME = "systemLog";
    private static final Logger logger = LoggerFactory.getLogger(LOG_FILE_NAME);

    public static void info(String logId, String msg) {
        String logMsg = formatLogMsg(logId, msg, null);
        logger.info(logMsg);
    }

    public static void warn(String logId, String msg) {
        warn(logId, msg, null);
    }

    public static void warn(String logId, String msg, Throwable throwable) {
        String logMsg = formatLogMsg(logId, msg, throwable);
        logger.warn(logMsg);
    }

    public static void error(String logId, String msg) {
        error(logId, msg, null);
    }

    public static void error(String logId, String msg, Throwable throwable) {
        String logMsg = formatLogMsg(logId, msg, throwable);
        logger.error(logMsg);
    }

    private static String formatLogMsg(String logId, String msg, Throwable throwable) {
        StringBuilder msgSb = new StringBuilder();
        msgSb.append(genClassMsg());
        msgSb.append(FIELD_SEPARATOR);
        msgSb.append(genLogId(logId));
        msgSb.append(FIELD_SEPARATOR);
        msgSb.append(genURI());
        msgSb.append(FIELD_SEPARATOR);
        msgSb.append(genIp());
        msgSb.append(FIELD_SEPARATOR);
        msgSb.append(genTraceId());
        msgSb.append(FIELD_SEPARATOR);
        msgSb.append(genMsgContent(msg));
        if (throwable != null) {
            msgSb.append(FIELD_SEPARATOR);
            msgSb.append(genThrowable(ExceptionUtils.getFullStackTrace(throwable)));
        }
        return msgSb.toString();
    }

    private static StringBuilder genMsgContent(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(FIELD_BEGIN);
        sb.append("CONTENT:");
        sb.append(msg);
        sb.append(FIELD_END);
        return sb;
    }

    private static StringBuilder genThrowable(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(FIELD_BEGIN);
        sb.append("THROWABLE:");
        sb.append(msg);
        sb.append(FIELD_END);
        return sb;
    }

    private static StringBuilder genURI() {
        StringBuilder sb = new StringBuilder();
        sb.append(FIELD_BEGIN);
        sb.append("URI:");
        sb.append(LogManager.getUri());
        sb.append(FIELD_END);
        return sb;
    }

    private static StringBuilder genIp() {
        StringBuilder sb = new StringBuilder();
        sb.append(FIELD_BEGIN);
        sb.append("IP:");
        sb.append(LogManager.getIp());
        sb.append(FIELD_END);
        return sb;
    }

    private static StringBuilder genLogId(String logId) {
        StringBuilder sb = new StringBuilder();
        sb.append(FIELD_BEGIN);
        sb.append("LOGID:");
        sb.append(logId);
        sb.append(FIELD_END);
        return sb;
    }

    private static StringBuilder genTraceId() {
        StringBuilder sb = new StringBuilder();
        sb.append(FIELD_BEGIN);
        sb.append("TRACEID:");
        sb.append(LogManager.getTraceId());
        sb.append(FIELD_END);
        return sb;
    }

    /**
     * 获取日志堆栈信息
     */
    private static StringBuilder genClassMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append(FIELD_BEGIN);
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        for (StackTraceElement ste : stacks) {
            if (!UnifyLogger.class.getName().equals(ste.getClassName())) {
                sb.append(ste.getClassName());
                sb.append(".");
                sb.append(ste.getMethodName());
                break;
            }
        }
        sb.append(FIELD_END);
        return sb;
    }
}
