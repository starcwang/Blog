package com.staryn.blog.service.encrypt;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-24 19:15:00
 */
public interface EncryptService {
    /**
     * 用户信息加密，生成token
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    public String encryptUser(String username, String password);
}
