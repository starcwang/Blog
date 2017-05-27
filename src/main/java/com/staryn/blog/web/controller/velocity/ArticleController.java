package com.staryn.blog.web.controller.velocity;

import com.staryn.blog.model.ArticleContents;
import com.staryn.blog.service.ArticleService;
import com.staryn.blog.util.LoggerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-12 15:23:00
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("/contents")
    @ResponseBody
    public Object contents() {
        LoggerUtil.info("logIdddd", "messagessssss");
        ModelAndView modelAndView = new ModelAndView();
        List<ArticleContents> articleContentsList = articleService.getArticleContents();
        modelAndView.addObject("articleContentsList", articleContentsList);
//        response.setContentType("text/html;charset=UTF-8");
        modelAndView.setViewName("contents");
        return modelAndView;
    }
}
