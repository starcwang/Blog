package com.star.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.star.blog.model.pojo.BlogModel;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-08 17:21:00
 */
@Repository
public interface BlogDao {
    BlogModel selectById(int id);

    void insertBlogModelReturnId(BlogModel blogModel);

    List<BlogModel> selectAll();
}
