package com.staryn.blog.model;

/**
 * @author <a href="mailto:wangchao.star@gmail.com">wangchao</a>
 * @date 2016-07-20 11:50:00
 */
public class CommonResponse<T> {
    private BStatus bStatus;
    private T data;

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
        private String code = "0";
        private String desc = "成功";

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
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
