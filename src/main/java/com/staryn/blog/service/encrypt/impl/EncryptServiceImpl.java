package com.staryn.blog.service.encrypt.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.staryn.blog.service.encrypt.EncryptService;
import com.staryn.blog.util.MD5Util;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-24 19:15:00
 */
@Service
public class EncryptServiceImpl implements EncryptService {
    @Value("${login.secret.key}")
    private String secret;

    @Override
    public String encryptUser(String username, String password) {
        return MD5Util.getMD5Str(secret + username + password + secret);
    }
}
