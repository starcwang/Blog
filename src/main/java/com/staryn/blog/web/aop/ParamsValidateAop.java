package com.staryn.blog.web.aop;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.staryn.blog.service.validator.ValidatorService;

/**
 * Controller层通用参数校验切面层
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 16:32:00
 */
public class ParamsValidateAop implements MethodInterceptor {
    @Resource
    private ValidatorService validatorService;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result;
        Object[] params = invocation.getArguments();
        for (Object obj : params) {
            if (!(obj instanceof ServletRequest) && !(obj instanceof ServletResponse)) {
                validatorService.validator(obj);
            }
        }
        result = invocation.proceed();
        return result;
    }
}
