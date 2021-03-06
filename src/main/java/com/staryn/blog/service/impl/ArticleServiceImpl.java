package com.staryn.blog.service.impl;

import com.staryn.blog.dao.ArticleDao;
import com.staryn.blog.model.ArticleContents;
import com.staryn.blog.model.pojo.ArticleModel;
import com.staryn.blog.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-12 15:38:00
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
