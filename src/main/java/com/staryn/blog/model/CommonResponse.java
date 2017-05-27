package com.staryn.blog.model;

import com.staryn.blog.common.enums.ErrorCode;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @since 2016-07-20 11:50:00
 */
public class CommonResponse<T> {
    private BStatus bStatus = new BStatus();
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(BStatus bStatus) {
        this.bStatus = bStatus;
    }

    public BStatus getbStatus() {
        return bStatus;
    }

    public void setbStatus(BStatus bStatus) {
        this.bStatus = bStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class BStatus {
        private Integer code = ErrorCode.OK.getCode();
        private String desc = ErrorCode.OK.getDesc();

        public BStatus(ErrorCode errorCode) {
            this.code = errorCode.getCode();
            this.desc = errorCode.getDesc();
        }

        public BStatus() {
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
