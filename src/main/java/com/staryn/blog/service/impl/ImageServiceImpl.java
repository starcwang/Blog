package com.staryn.blog.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.staryn.blog.common.enums.ErrorCode;
import com.staryn.blog.common.exception.CommonException;
import com.staryn.blog.common.exception.CommonException.AlarmType;
import com.staryn.blog.dao.ImageDao;
import com.staryn.blog.model.pojo.ImageModel;
import com.staryn.blog.model.vo.ImageUploadRes;
import com.staryn.blog.service.ImageService;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 11:45:00
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Value("${photos.path.dir}")
    private String imgSaveDir;

    @Resource
    private ImageDao imageDao;

    @Override
    public ImageUploadRes upload(MultipartFile imageFile, HttpServletRequest request) throws IOException {
        ImageUploadRes res = new ImageUploadRes();
        validate(imageFile);
        String fileName = RandomStringUtils.randomAlphabetic(32) + "." + FilenameUtils.getExtension(imageFile.getOriginalFilename());
        File file = new File(imgSaveDir + "/" + fileName);
        imageFile.transferTo(file);
        saveToDao(file.getAbsolutePath());
        res.setImgUrl(file.getAbsolutePath());
        return res;
    }

    private void saveToDao(String absolutePath) {
        ImageModel imageModel = new ImageModel();
        imageModel.setUrl(absolutePath);
        imageDao.insertImage(imageModel);
    }

    private void validate(MultipartFile imageFile) {
        if (imageFile == null || imageFile.isEmpty()) {
            throw new CommonException(AlarmType.ERROR, ErrorCode.ERROR_PARAM, "传入文件为空！");
        }
        if (!imageFile.getContentType().equals("image/jpeg")) {
            throw new CommonException(AlarmType.ERROR, ErrorCode.ERROR_PARAM, "传入图片格式不合法！");
        }
    }
}
