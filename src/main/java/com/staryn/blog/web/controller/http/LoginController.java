package com.staryn.blog.web.controller.http;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.staryn.blog.model.CommonResponse;
import com.staryn.blog.model.vo.ImageUploadRes;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 16:28:00
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request) throws Exception {
        CommonResponse<ImageUploadRes> response = new CommonResponse<ImageUploadRes>();
        return response;
    }
}
