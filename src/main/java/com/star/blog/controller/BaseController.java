package com.star.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-04-22 18:17:00
 */
@Controller
@RequestMapping(value = "/star/blog")
public class BaseController {

    @RequestMapping("/home")
    @ResponseBody
    public Object index() {
        return "启动成功";
    }
}
