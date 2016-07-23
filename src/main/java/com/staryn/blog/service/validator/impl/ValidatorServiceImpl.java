package com.staryn.blog.service.validator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang.StringUtils;

import com.staryn.blog.common.exception.IllegalParamException;
import com.staryn.blog.util.UnifyLogger;
import com.staryn.blog.service.validator.ValidatorService;

/**
 * 参数校验实现类
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2015-11-17 19:43:00
 */
public class ValidatorServiceImpl implements ValidatorService {

    private Validator validator;

    @Override
    public <T> void validator(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        List<String> errorMsgList = new ArrayList<String>();
        if (constraintViolations != null && constraintViolations.size() > 0) {
            for (ConstraintViolation<T> item : constraintViolations) {
                String msg = item.getPropertyPath().toString() + " " + item.getMessage();
                errorMsgList.add(msg);
                UnifyLogger.warn("validator_warn", msg);
            }
            String errorMsg = StringUtils.join(errorMsgList, ",");
            throw new IllegalParamException("传入参数错误：" + errorMsg);
        }
    }

    @Override
    public <T> List<String> validatorWithMessage(T t) {
        List<String> errorMessages = new ArrayList<String>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if (constraintViolations != null && constraintViolations.size() > 0) {
            String errorMessage;
            for (ConstraintViolation<T> item : constraintViolations) {
                errorMessage = item.getPropertyPath().toString() + " " + item.getMessage();
                errorMessages.add(errorMessage);
                UnifyLogger.warn("validator_warn", errorMessage);
            }
        }
        return errorMessages;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }
}
