package com.staryn.blog.dao;

import org.springframework.stereotype.Repository;

import com.staryn.blog.model.pojo.AdminModel;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-08 17:21:00
 */
@Repository
public interface AdminDao {
    AdminModel selectById(int id);

    AdminModel selectByUsername(String username);
}
