package com.wb.leila.designmodedemo.http;

import android.util.Log;

import com.lzy.okgo.OkGo;
import com.wb.leila.designmodedemo.http.callback.JsonCallback;

import java.util.Map;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/17 17:37
 * className  OkGoUtil
 * email leila329@163.com
 * description
 */
public class OkGoUtil {
    public static <T> void getRequets(String url, Object tag, Map<String, String> map, JsonCallback<T> callback) {

        Log.d("OkGoUtil", "method get");
        OkGo.<T>get(url)
                .tag(tag)
                .params(map)
                .execute(callback);
    }

    public static <T> void postRequest(String url, Object tag, Map<String, String> map, JsonCallback<T> callback) {

        Log.d("OkGoUtil", "method post");
        OkGo.<T>post(url)
                .tag(tag)
                .params(map)
                .execute(callback);
    }
}
