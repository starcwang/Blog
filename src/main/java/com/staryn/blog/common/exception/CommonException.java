package com.staryn.blog.common.exception;

import com.staryn.blog.common.enums.ErrorCode;

/**
 * 通用异常
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 16:32:00
 */
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -2604071107484564575L;

    private AlarmType alarmType;
    private ErrorCode errorCode;
    private String message;

    public CommonException(AlarmType alarmType, ErrorCode errorCode, String message) {
        this.alarmType = alarmType;
        this.errorCode = errorCode;
        this.message = message;
    }

    public CommonException(AlarmType alarmType, ErrorCode errorCode) {
        this.alarmType = alarmType;
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public AlarmType getAlarmType() {
        return alarmType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public enum AlarmType {
        INFO,
        WARN,
        ERROR
    }
}
