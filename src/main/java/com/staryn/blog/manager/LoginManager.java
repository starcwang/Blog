package com.staryn.blog.manager;

import org.apache.commons.lang.StringUtils;

/**
 * 用户登录状态管理类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-23 00:55:00
 */
public abstract class LoginManager {
    private static final ThreadLocal<String> usernameHolder = new ThreadLocal<>();
    private static final ThreadLocal<String> tokenHolder = new ThreadLocal<>();

    public static void init() {
        usernameHolder.set(null);
    }

    public static String getUsername() {
        return usernameHolder.get();
    }

    public static boolean isLogin() {
        return StringUtils.isNotBlank(usernameHolder.get());
    }

    public static void setUsername(String username) {
        if (StringUtils.isNotBlank(username)) {
            usernameHolder.set(username);
        }
    }

    public static String getToken() {
        return tokenHolder.get();
    }

    public static void setToken(String token) {
        if (StringUtils.isNotBlank(token)) {
            tokenHolder.set(token);
        }
    }
}
