package com.staryn.blog.common.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.staryn.blog.common.exceptin.CommonException;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 16:32:00
 */
public class ControllerExceptionAop implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        try {

            result = invocation.proceed();
        } catch (CommonException ce) {

        } catch (Exception e) {

        }
        return result;
    }
}
