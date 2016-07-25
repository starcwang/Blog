package com.staryn.blog.service.encrypt;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-24 19:15:00
 */
public interface EncryptService {
    /**
     * 用户信息加密，生成token
     * 生成策略：result = MD5(secret + username + MD5(password) + secret)
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    public String encryptUser(String username, String password);

    /**
     * 密码加密生成token
     * 生成策略：result = MD5(secret + username + md5Password + secret)
     *
     * @param username    用户名
     * @param md5Password md5后的密码
     * @return token
     */
    public String encryptPassword(String username, String md5Password);

    /**
     * 通过token判断是否已登录
     *
     * @param username 用户名
     * @param token    token
     * @return 是否登录
     */
    public boolean hasLogin(String username, String token);
}
