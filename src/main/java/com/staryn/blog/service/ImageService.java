package com.staryn.blog.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 11:45:00
 */
public interface ImageService {
    public void upload(MultipartFile imageFile, HttpServletRequest request) throws IOException;
}
