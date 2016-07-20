package com.staryn.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.staryn.blog.common.exceptin.CommonException;
import com.staryn.blog.service.ImageService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 11:45:00
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public void upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new CommonException("传入文件为空！");
        }
    }
}
