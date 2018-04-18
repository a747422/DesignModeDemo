package com.wb.leila.designmodedemo.bean;

import java.util.List;

/**
 * 我的页面全部信息。逻辑紊乱
 * Author:  Leila
 * Version: V1.0
 * Create: 2018/2/5 11:26
 * File: DataBean.java
 * E-mail:leila329@163.com
 */

public class DataBean {


    /**
     * id : f2b8fb4bbbe04a4dba16c99648f7c799
     * token:用户token
     * username :
     * sex :
     * phone : 15015517282
     * headimgurl :
     * autograph :
     * integral : 20000
     * iswx : 0是未绑定 1是绑定
     * inwb : 0
     * winUrl:获奖图片
     */

    private String id;

    private String token;

    private boolean isPerfect;
    private String username;
    private String sex;
    private String phone;
    private String headimgurl;
    private String autograph;
    private int iswx;
    private int inwb;


    private String winurl;

    /**
     * myfollowsum : 0 导师
     * followmysum : 0 学生
     * mutualsum : 0   同学
     */

    private int myfollowsum;
    private int followmysum;
    private int mutualsum;
    /**
     * userid : 用户主键
     * msg : 内容
     * url : /schoolFile/upload/image/20180130/rk0hsv1f52igbqd0fam4gf7941.jpg
     * createat : 创建时间
     * isfollow : 0 是否已关注帖子:0否，1是
     */

    private String userid;
    private String msg;
    private String url;
    private int createat;
    private int isfollow;
    /**
     * fabuloussum : 点赞
     * forwardsum : 转发
     * commentsum : 评论
     */

    private int fabuloussum;
    private int forwardsum;
    private int commentsum;
    /**
     * headImgUrlList : [{"headimgurl":"/schoolFile/upload/image/20180130/tqud07tqq6hkip36956qr86c5s.jpg"}]
     * sum : 1
     */

    private int sum;
    private List<DataBean> headImgUrlList;


    /**
     * postList : [{"id":"123","msg":"首个帖子","url":"/schoolFile/upload/image/20180130/rk0hsv1f52igbqd0fam4gf7941.jpg","fabuloussum":0,"commentsum":0,"forwardsum":0},{"id":"38b0e692785c41b18e99f8ad34c9c383","msg":"我的最新帖子详情","url":"/schoolFile/upload/image/20180130/tqud07tqq6hkip36956qr86c5s.jpg;/schoolFile/upload/image/20180130/tqud07tqq6hkip36956qr86c5s.jpg","fabuloussum":0,"commentsum":0,"forwardsum":0}]
     * user : {"id":"f2b8fb4bbbe04a4dba16c99648f7c799","username":"昵称","headimgurl":"/schoolFile/upload/image/20180130/tqud07tqq6hkip36956qr86c5s.jpg","autograph":"我的个性签名","isfollow":0}
     */

    private DataBean user;


    /**
     * 是否点赞
     */
    private int isfabulous;
    /**
     * balance : 10,400.00
     * integral : 30000
     */

    private String balance;
    private int integral;
    /**
     * return_code : SUCCESS
     * return_msg : OK
     * appid : wx3fda535ce56063cf
     * mch_id : 1500875731
     * nonce_str : QmAjMYM1NatZyi53
     * sign : A648FA979743B25F0C568F7EE210E457
     * result_code : SUCCESS
     * prepay_id : wx201803271422463331e3cd610201776130
     * trade_type : APP
     */

    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String prepay_id;
    private String trade_type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public boolean isPerfect() {
        return isPerfect;
    }

    public void setPerfect(boolean perfect) {
        isPerfect = perfect;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public int getIswx() {
        return iswx;
    }

    public void setIswx(int iswx) {
        this.iswx = iswx;
    }

    public int getInwb() {
        return inwb;
    }

    public void setInwb(int inwb) {
        this.inwb = inwb;
    }


    public String getWinurl() {
        return winurl;
    }

    public void setWinurl(String winurl) {
        this.winurl = winurl;
    }

    public int getMyfollowsum() {
        return myfollowsum;
    }

    public void setMyfollowsum(int myfollowsum) {
        this.myfollowsum = myfollowsum;
    }

    public int getFollowmysum() {
        return followmysum;
    }

    public void setFollowmysum(int followmysum) {
        this.followmysum = followmysum;
    }

    public int getMutualsum() {
        return mutualsum;
    }

    public void setMutualsum(int mutualsum) {
        this.mutualsum = mutualsum;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public int getCreateat() {
        return createat;
    }

    public void setCreateat(int createat) {
        this.createat = createat;
    }

    public int getIsfollow() {
        return isfollow;
    }

    public void setIsfollow(int isfollow) {
        this.isfollow = isfollow;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public List<DataBean> getHeadImgUrlList() {
        return headImgUrlList;
    }

    public void setHeadImgUrlList(List<DataBean> headImgUrlList) {
        this.headImgUrlList = headImgUrlList;
    }

    public int getFabuloussum() {
        return fabuloussum;
    }

    public void setFabuloussum(int fabuloussum) {
        this.fabuloussum = fabuloussum;
    }

    public int getForwardsum() {
        return forwardsum;
    }

    public void setForwardsum(int forwardsum) {
        this.forwardsum = forwardsum;
    }

    public int getCommentsum() {
        return commentsum;
    }

    public void setCommentsum(int commentsum) {
        this.commentsum = commentsum;
    }


    public DataBean getUser() {
        return user;
    }

    public void setUser(DataBean user) {
        this.user = user;
    }

    public int getIsfabulous() {
        return isfabulous;
    }

    public void setIsfabulous(int isfabulous) {
        this.isfabulous = isfabulous;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }


    @Override
    public String toString() {
        return "DataBean{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", isPerfect=" + isPerfect +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", autograph='" + autograph + '\'' +
                ", iswx=" + iswx +
                ", inwb=" + inwb +
                ", winurl='" + winurl + '\'' +
                ", myfollowsum=" + myfollowsum +
                ", followmysum=" + followmysum +
                ", mutualsum=" + mutualsum +
                ", userid='" + userid + '\'' +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", createat=" + createat +
                ", isfollow=" + isfollow +
                ", fabuloussum=" + fabuloussum +
                ", forwardsum=" + forwardsum +
                ", commentsum=" + commentsum +
                ", sum=" + sum +
                ", headImgUrlList=" + headImgUrlList +
                ", user=" + user +
                ", isfabulous=" + isfabulous +
                ", balance='" + balance + '\'' +
                ", integral=" + integral +
                ", return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", sign='" + sign + '\'' +
                ", result_code='" + result_code + '\'' +
                ", prepay_id='" + prepay_id + '\'' +
                ", trade_type='" + trade_type + '\'' +
                '}';
    }
}
