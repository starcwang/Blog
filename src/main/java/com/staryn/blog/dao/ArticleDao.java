package com.staryn.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.staryn.blog.model.pojo.ArticleModel;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-08 17:21:00
 */
@Repository
public interface ArticleDao {
    ArticleModel selectById(int id);

    void insertArticleReturnId(ArticleModel articleModel);

    List<ArticleModel> selectAll();
}
