package com.staryn.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.staryn.blog.model.pojo.ArticleModel;
import com.staryn.blog.util.JsonUtil;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-08 17:46:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
public class ArticleDaoTest {
    @Resource
    private ArticleDao articleDao;

    @Test
    public void selectAll() throws Exception {
        List<ArticleModel> articleModels = articleDao.selectAll();
        for (ArticleModel articleModel : articleModels) {
            System.out.println(JsonUtil.toJson(articleModel));
        }
    }

}