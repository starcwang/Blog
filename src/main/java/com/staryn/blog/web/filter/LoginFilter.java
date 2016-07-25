package com.staryn.blog.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.staryn.blog.common.consts.LoginConst;
import com.staryn.blog.manager.LoginManager;
import com.staryn.blog.service.LoginService;
import com.staryn.blog.service.encrypt.EncryptService;

/**
 * 登录过滤器
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 20:58:00
 */
public class LoginFilter extends GenericFilterBean {
    private EncryptService encryptService;
    private LoginService loginService;

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        encryptService = (EncryptService) context.getBean("encryptService");
        loginService = (LoginService) context.getBean("loginService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;
        LoginManager.init();
        Cookie[] cookies = httpReq.getCookies();
        String username = null;
        String token = null;
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie == null) {
                    continue;
                }
                if (LoginConst.USERNAME.equals(cookie.getName())) {
                    username = cookie.getValue();
                }
                if (LoginConst.TOKEN.equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(token)) {
            // 已登录
            if (encryptService.hasLogin(username, token)) {
                LoginManager.setUsername(username);
                LoginManager.setToken(token);
            }
            // cookie被篡改，删除cookie
            else {
                loginService.logout(httpReq, httpRes);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
