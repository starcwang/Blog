package com.staryn.blog.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

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

    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        List<String> myList = Lists.newArrayList("a", "b");
        modelAndView.addObject("name", "cc");
        modelAndView.addObject("myList", myList);
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
