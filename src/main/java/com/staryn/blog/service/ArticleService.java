package com.staryn.blog.service;

import com.staryn.blog.model.ArticleContents;

import java.util.List;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-12 15:26:00
 */
public interface ArticleService {
    public List<ArticleContents> getArticleContents();
}
