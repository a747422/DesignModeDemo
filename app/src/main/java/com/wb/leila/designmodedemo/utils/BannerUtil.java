package com.wb.leila.designmodedemo.utils;

import com.wb.leila.designmodedemo.adapter.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/16 16:06
 * className  BannerUtil
 * email leila329@163.com
 * description
 */
public class BannerUtil {

    private static volatile BannerUtil instance;

    /**
     * 单例模式
     * volatile的一个语义是禁止指令重排序优化，也就保证了instance变量被赋值的时候对象已经是初始化过的
     *
     * @return
     */
    public static BannerUtil getInstance() {
        if (instance == null) {
            synchronized (BannerUtil.class) {
                if (instance == null) {
                    instance = new BannerUtil();
                }
            }
        }
        return instance;
    }

    private BannerUtil() {
    }

    /**
     * 通用的banner 配置
     *
     * @param banner
     */
    private void initBanner(Banner banner) {
        if (banner == null) {
            LogUtil.e("banner == null");
            return;
        }
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //如果需要点击事件在方法传入点击事件
        // banner.setOnBannerListener(onBannerListener);

        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    /**
     * 显示圆形指示器和标题（垂直显示）
     *
     * @param banner
     * @param images
     * @param titles
     */
    public void setCircleTitle(Banner banner, List<?> images, List<String> titles) {
        if (banner == null) {
            LogUtil.e("banner == null");
            return;
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片集合
        banner.setImages(images);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //通用Banner配置
        initBanner(banner);
    }

    /**
     * 显示数字指示器
     *
     * @param banner
     * @param images
     */
    public void setNum(Banner banner, List<?> images) {
        if (banner == null) {
            LogUtil.e("banner == null");
            return;
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置图片集合
        banner.setImages(images);
        //通用Banner配置
        initBanner(banner);
    }

    /**
     * 显示圆形指示器
     *
     * @param banner
     * @param images
     */
    public void setCircle(Banner banner, List<?> images, OnBannerListener onBannerListener) {
        if (banner == null) {
            LogUtil.e("banner == null");
            return;
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片集合
        banner.setImages(images);
        //通用Banner配置
        initBanner(banner);
    }


//   变量
//    BannerConfig.NOT_INDICATOR 	不显示指示器和标题 	setBannerStyle
//    BannerConfig.CIRCLE_INDICATOR 	显示圆形指示器 	setBannerStyle
//    BannerConfig.NUM_INDICATOR 	显示数字指示器 	setBannerStyle
//    BannerConfig.NUM_INDICATOR_TITLE 	显示数字指示器和标题 	setBannerStyle
//    BannerConfig.CIRCLE_INDICATOR_TITLE 	显示圆形指示器和标题（垂直显示） 	setBannerStyle
//    BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE 	显示圆形指示器和标题（水平显示） 	setBannerStyle
//    BannerConfig.LEFT 	指示器居左 	setIndicatorGravity
//    BannerConfig.CENTER 	指示器居中 	setIndicatorGravity
//    BannerConfig.RIGHT 	指示器居右 	setIndicatorGravity

//    方法：
//    setBannerStyle(int bannerStyle) 	设置轮播样式（默认为CIRCLE_INDICATOR） 	无
//    setIndicatorGravity(int type) 	设置指示器位置（没有标题默认为右边,有标题时默认左边） 	无
//    isAutoPlay(boolean isAutoPlay) 	设置是否自动轮播（默认自动） 	无
//    setViewPagerIsScroll(boolean isScroll) 	设置是否允许手动滑动轮播图（默认true） 	1.4.5开始
//    update(List<?> imageUrls,List titles) 	更新图片和标题 	1.4.5开始
//    update(List<?> imageUrls) 	更新图片 	1.4.5开始
//    startAutoPlay() 	开始轮播 	1.4开始，此方法只作用于banner加载完毕-->需要在start()后执行
//    stopAutoPlay() 	结束轮播 	1.4开始，此方法只作用于banner加载完毕-->需要在start()后执行
//    start() 	开始进行banner渲染（必须放到最后执行） 	1.4开始
//    setOffscreenPageLimit(int limit) 	同viewpager的方法作用一样 	1.4.2开始
//    setBannerTitle(String[] titles) 	设置轮播要显示的标题和图片对应（如果不传默认不显示标题） 	1.3.3结束
//    setBannerTitleList(List titles) 	设置轮播要显示的标题和图片对应（如果不传默认不显示标题） 	1.3.3结束
//    setBannerTitles(List titles) 	设置轮播要显示的标题和图片对应（如果不传默认不显示标题） 	1.4开始
//    setDelayTime(int time) 	设置轮播图片间隔时间（单位毫秒，默认为2000） 	无
//    setImages(Object[]/List<?> imagesUrl) 	设置轮播图片(所有设置参数方法都放在此方法之前执行) 	1.4后去掉数组传参
//    setImages(Object[]/List<?> imagesUrl,OnLoadImageListener listener) 	设置轮播图片，并且自定义图片加载方式 	1.3.3结束
//    setOnBannerClickListener(this) 	设置点击事件，下标是从1开始 	无（1.4.9以后废弃了）
//    setOnBannerListener(this) 	设置点击事件，下标是从0开始 	1.4.9以后
//    setOnLoadImageListener(this) 	设置图片加载事件，可以自定义图片加载方式 	1.3.3结束
//    setImageLoader(Object implements ImageLoader) 	设置图片加载器 	1.4开始
//    setOnPageChangeListener(this) 	设置viewpager的滑动监听 	无
//    setBannerAnimation(Class<? extends PageTransformer> transformer) 	设置viewpager的默认动画,传值见动画表 	无
//    setPageTransformer(boolean reverseDrawingOrder, ViewPager.PageTransformer transformer) 	设置viewpager的自定义动画 	无
}
