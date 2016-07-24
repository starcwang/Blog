package com.staryn.blog.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.staryn.blog.common.enums.ErrorCode;
import com.staryn.blog.common.exception.CommonException;
import com.staryn.blog.common.exception.CommonException.AlarmType;
import com.staryn.blog.dao.AdminDao;
import com.staryn.blog.model.pojo.AdminModel;
import com.staryn.blog.model.vo.LoginReq;
import com.staryn.blog.model.vo.LoginRes;
import com.staryn.blog.service.LoginService;
import com.staryn.blog.util.MD5Util;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-24 18:37:00
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AdminDao adminDao;

    @Override
    public LoginRes login(LoginReq loginReq, HttpServletRequest request, HttpServletResponse response) {
        LoginRes loginRes = new LoginRes();
        AdminModel adminModel = adminDao.selectByUsername(loginReq.getUsername());
        // 登录成功
        if (MD5Util.getMD5Str(loginReq.getPassword()).equals(adminModel.getPassword())) {
            loginRes.setLoginSuc(true);

        } else {
            throw new CommonException(AlarmType.ERROR, ErrorCode.ERROR_LOGIN, "用户名或密码错误！");
        }
        return loginRes;
    }
}
