package com.staryn.blog.service.impl;

import com.staryn.blog.common.consts.LoginConst;
import com.staryn.blog.common.enums.ErrorCode;
import com.staryn.blog.common.exception.CommonException;
import com.staryn.blog.common.exception.CommonException.AlarmType;
import com.staryn.blog.dao.AdminDao;
import com.staryn.blog.model.pojo.AdminModel;
import com.staryn.blog.model.vo.LoginReq;
import com.staryn.blog.model.vo.LoginRes;
import com.staryn.blog.model.vo.LogoutRes;
import com.staryn.blog.service.LoginService;
import com.staryn.blog.service.encrypt.EncryptService;
import com.staryn.blog.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-24 18:37:00
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AdminDao adminDao;
    @Resource
    private EncryptService encryptService;

    @Override
    public LoginRes login(LoginReq loginReq, HttpServletRequest request, HttpServletResponse response) {
        LoginRes loginRes = new LoginRes();
        AdminModel adminModel = adminDao.selectByUsername(loginReq.getUsername());
        // 登录成功
        if (MD5Util.getMD5Str(loginReq.getPassword()).equals(adminModel.getPassword())) {
            loginRes.setLoginSuc(true);
            Cookie cookie;
            cookie = new Cookie(LoginConst.USERNAME, loginReq.getUsername());
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
            cookie = new Cookie(LoginConst.TOKEN, encryptService.encryptUser(loginReq.getUsername(), loginReq.getPassword()));
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
        } else {
            throw new CommonException(AlarmType.ERROR, ErrorCode.ERROR_LOGIN, "用户名或密码错误！");
        }
        return loginRes;
    }

    @Override
    public LogoutRes logout(HttpServletRequest request, HttpServletResponse response) {
        LogoutRes logoutRes = new LogoutRes();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                // 找到需要删除的Cookie
                if (LoginConst.USERNAME.equals(name) || LoginConst.TOKEN.equals(name)) {
                    // 设置生存期为0
                    cookie.setMaxAge(0);
                    // 设回Response中生效
                    response.addCookie(cookie);
                }
            }
        }
        logoutRes.setLogoutSuc(true);
        return logoutRes;
    }
}
