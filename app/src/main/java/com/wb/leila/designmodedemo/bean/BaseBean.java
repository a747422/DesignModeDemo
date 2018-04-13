package com.wb.leila.designmodedemo.bean;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/13 10:56
 * className  BaseBean
 * email leila329@163.com
 * description
 */
public class BaseBean {
    public String code;

    private BaseBean(Builder builder) {
        this.code = builder.code;
    }

    /**
     * 可以增加代码的可读性
     */
    public  static class Builder {
        private String code;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public BaseBean build() {
            return new BaseBean(this);
        }
    }
}
