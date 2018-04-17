package com.wb.leila.designmodedemo.http;

import com.google.gson.Gson;
import com.wb.leila.designmodedemo.model.LzyResponse;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/17 16:58
 * className  HttpException
 * email leila329@163.com
 * description
 */
public class HttpException extends IllegalAccessException {
    private LzyResponse errorBean;

    public HttpException(String s) {
        super(s);
        errorBean = new Gson().fromJson(s, LzyResponse.class);
    }


    public LzyResponse getErrorBean() {
        return errorBean;
    }
}
