package com.staryn.blog.service.encrypt.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.staryn.blog.dao.AdminDao;
import com.staryn.blog.model.pojo.AdminModel;
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

    @Resource
    private AdminDao adminDao;

    @Override
    public String encryptUser(String username, String password) {
        return MD5Util.getMD5Str(secret + username + MD5Util.getMD5Str(password) + secret);
    }

    @Override
    public String encryptPassword(String username, String md5Password) {
        return MD5Util.getMD5Str(secret + username + md5Password + secret);
    }

    @Override
    public boolean hasLogin(String username, String token) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(token)) {
            return false;
        }
        AdminModel adminModel = adminDao.selectByUsername(username);
        return token.equals(this.encryptPassword(adminModel.getUsername(), adminModel.getPassword()));
    }
}
