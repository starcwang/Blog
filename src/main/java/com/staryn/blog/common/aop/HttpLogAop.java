package com.staryn.blog.common.aop;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.staryn.blog.log.LogManager;
import com.staryn.blog.log.UnifyLogger;
import com.staryn.blog.util.JsonUtil;

/**
 * Controller层request和response日志记录切面层
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 16:32:00
 */
public class HttpLogAop implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String formattedURI = getFormattedRequestURI(request);
        String logId = "http_" + formattedURI;
        //记录请求信息
        this.logRequest(logId, request);
        Object response = invocation.proceed();
        //记录返回信息
        UnifyLogger.info(logId + "_response", "请求耗时：" + LogManager.getReqProcessTime() / 1000d + "s, http请求结果：" + JsonUtil.toJson(response));

        return response;
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

        UnifyLogger.info(logId + "_request", "请求参数" + JsonUtil.toJson(params));
    }


}
