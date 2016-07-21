package com.staryn.blog.common.exception;

/**
 * 参数校验异常
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2015-11-17 19:59:00
 * @see RuntimeException
 */
public class IllegalParamException extends RuntimeException {
    private static final long serialVersionUID = -1532068162254725560L;
    private String message;

    public IllegalParamException(String errorMessage) {
        super(errorMessage);
        this.message = errorMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
