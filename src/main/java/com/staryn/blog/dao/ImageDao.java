package com.staryn.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.staryn.blog.model.pojo.ImageModel;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-22 11:56:00
 */
@Repository
public interface ImageDao {
    ImageModel selectById(int id);

    void insertImage(ImageModel imageModel);

    List<ImageModel> selectAll();
}
