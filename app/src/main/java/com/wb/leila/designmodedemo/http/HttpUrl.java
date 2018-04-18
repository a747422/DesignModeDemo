package com.wb.leila.designmodedemo.http;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/17 16:24
 * className  HttpUrl
 * email leila329@163.com
 * description
 */
public class HttpUrl {
    /**
     * BASE链接
     */
    public static final String URL_BASE = "https://www.gzjscm.cn";
    /**
     * 登陆链接
     */
    public static final String URL_LOGIN = URL_BASE + "/school/wb/front/login";
    /**
     * 三方登陆链接
     */
    public static final String URL_OTHER_LOGIN = URL_BASE + "/school/wb/front/otherLogin";
    /**
     * 登出链接
     */
    public static final String URL_LOGOUT = URL_BASE + "/school/wb/front/logOut";
    /**
     * 验证码链接
     */
    public static final String URL_CODE = URL_BASE + "/school/wb/front/getSmsCode";
    /**
     * 注册链接
     */
    public static final String URL_REG = URL_BASE + "/school/wb/front/register";
    /**
     * 重置链接
     */
    public static final String URL_RESET = URL_BASE + "/school/wb/front/resetPassword";
    /**
     * 首页轮播图片链接
     */
    public static final String URL_LOOP_NEWEST = URL_BASE + "/school/wb/front/getHomeImg";
    /**
     * 首页分类链接
     */
    public static final String URL_HEAD_NEWEST = URL_BASE + "/school/wb/front/getTypeList";
}
