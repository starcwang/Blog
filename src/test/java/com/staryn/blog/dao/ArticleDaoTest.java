package com.staryn.blog.dao;

import com.staryn.blog.model.pojo.ArticleModel;
import com.staryn.blog.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-08 17:46:00
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