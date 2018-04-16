package com.wb.leila.designmodedemo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;


/**
 * @author Leila
 * @version V1.0
 * @date 2018/4/16 16:07
 * className  GlideImageLoader
 * email leila329@163.com
 * description
 */
public class GlideImageLoader extends ImageLoader {
   Integer im;

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */
        im = (Integer) path;
        imageView.setImageResource(im);
    }


}
