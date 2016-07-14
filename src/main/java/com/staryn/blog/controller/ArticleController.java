package com.staryn.blog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.staryn.blog.log.UnifyLogger;
import com.staryn.blog.model.ArticleContents;
import com.staryn.blog.service.ArticleService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-12 15:23:00
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("/contents")
    @ResponseBody
    public Object contents() {
        UnifyLogger.info("logIdddd", "messagessssss");
        ModelAndView modelAndView = new ModelAndView();
        List<ArticleContents> articleContentsList = articleService.getArticleContents();
        modelAndView.addObject("articleContentsList", articleContentsList);
//        response.setContentType("text/html;charset=UTF-8");
        modelAndView.setViewName("contents");
        return modelAndView;
    }
}
