package com.ybe.ybeframes;

import android.app.Application;

import com.orhanobut.logger.Logger;
import com.ybe.ybeframes.utils.ImageLoaderUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by lhh on 2017/11/13.
 */

public class MyApplication extends Application{

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // logger 初始化
        Logger.init("LLKJ");
        // imageloader 初始化
        ImageLoaderUtils.initConfig(this);
        // OKHttp 初始化
        OkHttpUtils.getInstance().debug("OKHttpUtils",false).setConnectTimeout(100000, TimeUnit.MILLISECONDS);
        OkHttpUtils.getInstance().setCertificates();
    }

    public static MyApplication getInstance(){
        return instance;
    }

}
