package com.staryn.blog.controller.velocity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 11:43:00
 */
@Controller
@RequestMapping(value = "/about")
public class AboutController {

    @RequestMapping("/info")
    @ResponseBody
    public Object info() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }
}
