package com.staryn.blog.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-14 16:19:00
 */
public abstract class UnifyLogger {
    private static final String FIELD_BEGIN = "[";
    private static final String FIELD_END = "]";
    private static final String FIELD_SEPARATOR = "######";
    private static final String LOG_FILE_NAME = "systemlog";
    private static final Logger logger = LoggerFactory.getLogger(LOG_FILE_NAME);

    public static void info(String logId, String msg) {
        String logMsg = formatLogMsg(logId, msg);
        logger.info(logMsg);
    }

    private static String formatLogMsg(String logId, String msg) {
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
