package com.staryn.blog.web.aop;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.staryn.blog.manager.LogManager;
import com.staryn.blog.service.validator.ValidatorService;
import com.staryn.blog.util.JsonUtil;
import com.staryn.blog.util.LoggerUtil;

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

    /**
     * 将请求地址中的斜杠连接符替换为短线
     */
    private String getFormattedRequestURI(HttpServletRequest request) {
        String uri = request.getRequestURI().replaceAll("/+", "-");
        if (uri.startsWith("-")) {
            uri = uri.substring(1);
        }

        return uri;
    }

    /**
     * 记录请求参数
     */
    private void logRequest(String logId, HttpServletRequest request) {
        // 请求参数日志信息
        Map<String, String> params = new HashMap<String, String>();
        Enumeration enumeration = request.getParameterNames();
        if (null != enumeration) {
            while (enumeration.hasMoreElements()) {
                Object element = enumeration.nextElement();
                if (null != element) {
                    String paramName = (String) element;
                    String paramValue = request.getParameter(paramName);
                    params.put(paramName, paramValue);
                }
            }
        }

        LoggerUtil.info(logId + "_request", "请求参数" + JsonUtil.toJson(params));
    }


}
