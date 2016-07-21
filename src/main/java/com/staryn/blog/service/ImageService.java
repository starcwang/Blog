package com.staryn.blog.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.staryn.blog.model.vo.ImageUploadRes;

/**
 * 图片服务
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 11:45:00
 */
public interface ImageService {
    /**
     * 图片上传服务
     *
     * @param imageFile 图片对象
     * @param request   http request
     * @return 上传结果
     * @throws IOException 读写异常
     */
    public ImageUploadRes upload(MultipartFile imageFile, HttpServletRequest request) throws IOException;
}
