package com.wb.leila.designmodedemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.model.Response;
import com.wb.leila.designmodedemo.adapter.MainRecyclerAdapter;
import com.wb.leila.designmodedemo.base.BaseActivity;
import com.wb.leila.designmodedemo.bean.BaseBean;
import com.wb.leila.designmodedemo.callback.JsonCallback;
import com.wb.leila.designmodedemo.http.OkGoUtil;
import com.wb.leila.designmodedemo.model.LzyResponse;
import com.wb.leila.designmodedemo.utils.BannerUtil;
import com.wb.leila.designmodedemo.utils.LogUtil;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wb.leila.designmodedemo.http.HttpUrl.URL_LOGIN;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_remove)
    Button btnRemove;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.banner)
    Banner banner;

    MainRecyclerAdapter mainRecyclerAdapter;
    BaseBean.Builder builder;
    BaseBean baseBean;
    List<BaseBean> baseBeanList;
    int i = 0;
    Observable<BaseBean> observable = new Observable<BaseBean>();
    Observer<BaseBean> observer = new Observer<BaseBean>() {
        @Override
        public void onUpdate(Observable<BaseBean> observable, List<BaseBean> data) {
            mainRecyclerAdapter.notifyDataSetChanged();
        }
    };

    /**
     * 测试图片地址
     */
    List<Integer> listImg = new ArrayList<>();
    List<String> listTitle = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //观察者订阅
        observable.register(observer);

        builder = new BaseBean.Builder();
        baseBean = builder.build();
        baseBeanList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            baseBean = builder.code("默认次数" + i).build();
            baseBeanList.add(baseBean);
        }
        //布局管理器，垂直布局显示
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //适配器初始化
        mainRecyclerAdapter = new MainRecyclerAdapter(R.layout.main_item, baseBeanList);
        //RecyclerView 添加管理器和适配器
        recy.setLayoutManager(layoutManager);
        recy.setAdapter(mainRecyclerAdapter);
        //QuickAdapter提供的加载动画，当前为缩放
        mainRecyclerAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);


    }

    @Override
    protected void initData() {
        listImg.add(R.drawable.iv);
        listTitle.add("张韶涵");
        listImg.add(R.drawable.iv);
        listTitle.add("张韶涵+1");
        BannerUtil.getInstance().setNum(banner, listImg);
    }

    @Override
    protected void initCilck() {

    }

    @OnClick({R.id.btn_login, R.id.btn_add, R.id.btn_remove})
    void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Map<String, String> map = new HashMap<>();
                map.put("phone", "1355255329");
                map.put("password", "123123");
                map.put("type", "0");
                //调用二次封装的okgo，将成功数据返回，错误数据在JsonCallback中处理
                OkGoUtil.postRequest(URL_LOGIN, this, map, new JsonCallback<LzyResponse>() {
                    @Override
                    public void onSuccess(Response<LzyResponse> response) {
                        LogUtil.d(response.body());
                    }
                });
                map.clear();
                break;
            case R.id.btn_add:
                baseBean = builder.code("增加" + i + "次").build();
                baseBeanList.add(baseBean);
                observable.notifyObservers(baseBeanList);
                i++;
                break;
            case R.id.btn_remove:
                if (baseBeanList == null) {
                    // 没有数据的时候默认显示该布局
                    mainRecyclerAdapter.setEmptyView(R.layout.main_null);
                    throw new NullPointerException("baseBeanList无数据" + baseBeanList.size());
                }
                if (baseBeanList.size() > 0) {
                    baseBeanList.remove(0);
                    observable.notifyObservers(baseBeanList);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        if (banner != null) {
            banner.startAutoPlay();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消订阅
        observable.unregister(observer);
    }

}
