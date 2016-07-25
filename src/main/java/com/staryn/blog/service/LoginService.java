package com.staryn.blog.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staryn.blog.model.vo.LoginReq;
import com.staryn.blog.model.vo.LoginRes;
import com.staryn.blog.model.vo.LogoutRes;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-24 18:37:00
 */
public interface LoginService {
    public LoginRes login(LoginReq loginReq, HttpServletRequest request, HttpServletResponse response);
    public LogoutRes logout(HttpServletRequest request, HttpServletResponse response);
}
