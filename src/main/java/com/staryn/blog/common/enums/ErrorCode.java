package com.staryn.blog.common.enums;

/**
 * 错误码
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-21 20:10:00
 */
public enum ErrorCode {
    OK(0, "成功"),
    ERROR(2, "系统错误"),
    ERROR_PARAM(3, "参数错误"),
    ERROR_LOGIN(4, "登录失败"),;

    private int code;
    private String desc;

    ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
