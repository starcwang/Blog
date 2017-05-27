package com.staryn.blog.dao;

import com.staryn.blog.model.pojo.ArticleModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-08 17:21:00
 */
@Repository
public interface ArticleDao {
    ArticleModel selectById(int id);

    void insertArticle(ArticleModel articleModel);

    List<ArticleModel> selectAll();
}
