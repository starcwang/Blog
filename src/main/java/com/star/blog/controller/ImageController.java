package com.star.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-13 16:28:00
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("imgFile") MultipartFile file, HttpServletRequest request) {
        return null;
    }
}
