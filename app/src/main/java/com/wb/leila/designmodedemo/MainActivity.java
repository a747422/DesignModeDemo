package com.wb.leila.designmodedemo;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.model.Response;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.wb.leila.designmodedemo.adapter.MainRecyclerAdapter;
import com.wb.leila.designmodedemo.base.BaseActivity;
import com.wb.leila.designmodedemo.bean.BaseBean;
import com.wb.leila.designmodedemo.bean.DataBean;
import com.wb.leila.designmodedemo.http.callback.JsonCallback;
import com.wb.leila.designmodedemo.http.OkGoUtil;
import com.wb.leila.designmodedemo.http.model.LzyResponse;
import com.wb.leila.designmodedemo.model.RecycleViewUtils;
import com.wb.leila.designmodedemo.utils.BannerUtil;
import com.wb.leila.designmodedemo.utils.LogUtil;
import com.wb.leila.designmodedemo.utils.ToastUtil;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wb.leila.designmodedemo.http.HttpUrl.URL_LOGIN;

public class MainActivity extends BaseActivity {
    @BindView(R.id.ll_main)
    LinearLayout linearLayout;
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
    RecyclerView.LayoutManager layoutManager;
    BaseBean.Builder builder;
    DataBean dataBean;
    List<DataBean> dataBeanList;
    List<DataBean> dataBeans;
    int i = 0;
    Observable<DataBean> observable = new Observable<DataBean>();
    Observer<DataBean> observer = new Observer<DataBean>() {
        @Override
        public void onUpdate(Observable<DataBean> observable, List<DataBean> data) {
            //mainRecyclerAdapter.notifyDataSetChanged();
        }
    };

    /**
     * 测试图片地址
     */
    List<Integer> listImg = new ArrayList<>();
    List<String> listTitle = new ArrayList<>();
    int mCurrentCounter;
    boolean isErr = true;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //观察者订阅
        observable.register(observer);
        builder = new BaseBean.Builder();
        dataBean = new DataBean();
        dataBeanList = new ArrayList<>();
        dataBeans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dataBean.setMsg("aaaa" + i);
            dataBeanList.add(dataBean);
        }
        //布局管理器，垂直布局显示
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //适配器初始化
        mainRecyclerAdapter = new MainRecyclerAdapter(R.layout.main_item, dataBeanList);
        //RecyclerView 添加管理器和适配器
        recy.setLayoutManager(layoutManager);
        recy.setAdapter(mainRecyclerAdapter);
        //QuickAdapter提供的加载动画，当前为缩放
        mainRecyclerAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        initEmpty(linearLayout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("点击重试");
                refreshInit();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        //do something
                        goneEmpty();
                    }
                }, 2000);
            }
        });
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
        // 没有数据的时候默认显示该布局,布局有数据都不会显示到空布局
        //   mainRecyclerAdapter.setEmptyView(R.layout.main_null, (ViewGroup) recy.getParent());
        mainRecyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                ToastUtil.showToast(String.valueOf(position));
            }
        });
//        recy.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
//                    //获取最后一个可见view的位置
//                    int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
//                    if (lastVisiblePosition >= layoutManager.getItemCount() - 1) {

        mainRecyclerAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                recy.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //mCurrentCounter 应该动态设置，判断的20应该根据服务器返回的条数进行调整。
                        if (mCurrentCounter >= 20) {

                            //数据全部加载完毕
                            mainRecyclerAdapter.loadMoreEnd();

                        } else {
                            if (isErr) {
                                dataBeans.clear();
                                //成功获取更多数据
                                for (int i = 0; i < 5; i++) {
                                    dataBean.setMsg("aaaa" + i);
                                    dataBeans.add(dataBean);
                                }
                                //不能引用初始化时使用的list，会出现无法加载数据。
                                mainRecyclerAdapter.addData(dataBeans);
                                mCurrentCounter = mainRecyclerAdapter.getData().size();
                                //完成
                                mainRecyclerAdapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                ToastUtil.showToast("获取数据失败");
                                //加载失败
                                mainRecyclerAdapter.loadMoreFail();
                            }
                        }
                    }
                }, 2000);


            }
        }, recy);


//                    }
//                }
//
//            }
//        });


    }

    @OnClick({R.id.btn_login, R.id.btn_add, R.id.btn_remove})
    void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Map<String, String> map = new HashMap<>();
                map.put("phone", "13556255329");
                map.put("password", "123123");
                map.put("type", "0");
                //调用二次封装的okgo，将成功数据返回，错误数据在JsonCallback中处理
                OkGoUtil.postRequest(URL_LOGIN, this, map, new JsonCallback<LzyResponse<DataBean>>() {
                    @Override
                    public void onSuccess(Response<LzyResponse<DataBean>> response) {
                        LogUtil.d(response.body());
                        skipActivity(RecycleViewAcctivity.class);
                    }
                });
                map.clear();
                break;
            case R.id.btn_add:
//                baseBean = builder.code("增加" + i + "次").build();
//                baseBeanList.add(baseBean);
//                observable.notifyObservers(baseBeanList);
//                i++;
                break;
            case R.id.btn_remove:
//                if (baseBeanList == null) {
//                    // 没有数据的时候默认显示该布局
//                    mainRecyclerAdapter.setEmptyView(R.layout.main_null);
//                    throw new NullPointerException("baseBeanList无数据" + baseBeanList.size());
//                }
//                if (baseBeanList.size() > 0) {
//                    baseBeanList.remove(0);
//                    observable.notifyObservers(baseBeanList);
//                }
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
