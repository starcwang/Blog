package com.staryn.blog.service;

import java.util.List;

import com.staryn.blog.model.ArticleContents;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-12 15:26:00
 */
public interface ArticleService {
    public List<ArticleContents> getArticleContents();
}
