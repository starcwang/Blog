package com.staryn.blog.web.controller.http;

import com.staryn.blog.model.CommonResponse;
import com.staryn.blog.model.vo.ImageUploadRes;
import com.staryn.blog.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-13 16:28:00
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {
    @Resource
    private ImageService imageService;

    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile imgFile, HttpServletRequest request) throws Exception {
        CommonResponse<ImageUploadRes> response = new CommonResponse<ImageUploadRes>();
        response.setData(imageService.upload(imgFile, request));
        return response;
    }
}
