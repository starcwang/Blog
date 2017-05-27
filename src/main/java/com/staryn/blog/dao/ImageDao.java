package com.staryn.blog.dao;

import com.staryn.blog.model.pojo.ImageModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-22 11:56:00
 */
@Repository
public interface ImageDao {
    ImageModel selectById(int id);

    void insertImage(ImageModel imageModel);

    List<ImageModel> selectAll();
}
