package com.staryn.blog.common.exceptin;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 16:32:00
 */
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -2604071107484564575L;

    private String message;

    public CommonException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
