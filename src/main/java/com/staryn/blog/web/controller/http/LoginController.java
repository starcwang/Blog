package com.staryn.blog.web.controller.http;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.staryn.blog.model.CommonResponse;
import com.staryn.blog.model.vo.ImageUploadRes;
import com.staryn.blog.model.vo.LoginReq;
import com.staryn.blog.model.vo.LoginRes;
import com.staryn.blog.service.LoginService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 16:28:00
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(LoginReq loginReq, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonResponse<LoginRes> commonResponse = new CommonResponse<LoginRes>();
        LoginRes loginRes = loginService.login(loginReq, request, response);
        commonResponse.setData(loginRes);
        return commonResponse;
    }
}
