package com.star.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.star.blog.dao.ArticleDao;
import com.star.blog.model.ArticleContents;
import com.star.blog.model.pojo.ArticleModel;
import com.star.blog.service.ArticleService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-12 15:38:00
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    public List<ArticleContents> getArticleContents() {
        List<ArticleModel> articleModels = articleDao.selectAll();
        List<ArticleContents> articleContentsList = new ArrayList<>();
        for (ArticleModel articleModel : articleModels) {
            ArticleContents articleContents = new ArticleContents();
            BeanUtils.copyProperties(articleModel, articleContents);
            articleContentsList.add(articleContents);
        }
        return articleContentsList;
    }
}
