package com.staryn.blog.common.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;

import com.staryn.blog.common.enums.ErrorCode;
import com.staryn.blog.common.exception.CommonException;
import com.staryn.blog.common.exception.IllegalParamException;
import com.staryn.blog.log.LogManager;
import com.staryn.blog.log.UnifyLogger;
import com.staryn.blog.model.CommonResponse;
import com.staryn.blog.model.CommonResponse.BStatus;

/**
 * Controller层异常切面
 *
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 16:32:00
 */
public class ControllerExceptionAop implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result;
        try {
            result = invocation.proceed();
        } catch (IllegalParamException ipe) {
            UnifyLogger.error(LogManager.getUri() + "_param_error", ipe.getMessage(), ipe);
            CommonResponse commonResponse = new CommonResponse<>(new BStatus(ErrorCode.ERROR_PARAM));
            if (StringUtils.isNotBlank(ipe.getMessage())) {
                commonResponse.getbStatus().setDesc(ipe.getMessage());
            }
            result = commonResponse;
        } catch (CommonException ce) {
            switch (ce.getAlarmType()) {
                case INFO:
                    UnifyLogger.info(LogManager.getUri() + "_common_info", ce.getMessage());
                    break;
                case WARN:
                    UnifyLogger.warn(LogManager.getUri() + "_common_warn", ce.getMessage(), ce);
                    break;
                case ERROR:
                    UnifyLogger.error(LogManager.getUri() + "_common_error", ce.getMessage(), ce);
                    break;
                default:
                    break;
            }
            CommonResponse commonResponse = new CommonResponse<>(new BStatus(ce.getErrorCode()));
            if (StringUtils.isNotBlank(ce.getMessage())) {
                commonResponse.getbStatus().setDesc(ce.getMessage());
            }
            result = commonResponse;
        } catch (Exception e) {
            UnifyLogger.error(LogManager.getUri() + "_unknown_error", e.getMessage(), e);
            result = new CommonResponse<>(new BStatus(ErrorCode.ERROR));
        }
        return result;
    }
}
