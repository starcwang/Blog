package com.staryn.blog.service.validator;

import java.util.List;

/**
 * 参数校验服务
 *
 * @author wangchao.wang
 * @date 2015-11-17 19:42:00
 */
public interface ValidatorService {
    /**
     * 按照注解参数校验，失败抛出异常
     *
     * @param t 欲校验参数
     */
    public <T> void validator(T t);

    /**
     * 按照注解参数校验，返回抛出异常
     *
     * @param t 欲校验参数
     * @return 不合法的message
     */
    public <T> List<String> validatorWithMessage(T t);
}
