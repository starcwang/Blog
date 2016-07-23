package com.staryn.blog.web.controller.velocity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 11:42:00
 */
@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {
    @RequestMapping("/list")
    @ResponseBody
    public Object list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gallery");
        return modelAndView;
    }
}
