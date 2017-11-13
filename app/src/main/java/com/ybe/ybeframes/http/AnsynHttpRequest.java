package com.ybe.ybeframes.http;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.ybe.ybeframes.utils.JsonUtils;
import com.ybe.ybeframes.utils.NetworkUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;
import java.util.Observable;

import okhttp3.Call;

/**
 * Created by lhh on 2017/11/9
 */

public class AnsynHttpRequest {

    public static final int POST = 1; // post 请求
    public static final int GET = 2; // get 请求

    public static final int SUCCESS_HTTP = 200; //请求成功

    public static final int FALENT_HTTP = 4001; //请求失败
    public static final int FALENT_NET_HTTP = 4002; // 网络请求失败
    public static final int FALENT_JSON_HTTP = 4003;// json 解析失败

    /**
     *   Post 请求
     * @param c  上下文对象
     * @param sendType  请求类型（post  或者 get）
     * @param map  Map 集合
     * @param url  请求接口地址
     * @param callback  异步回调
     * @param method  接口标识
     */
    public static void requestHttp(Context c,int sendType,Map<String,String> map, String url, final ObserverCallBack callback, final int method){
        // 判断网络
        if (!NetworkUtils.isNetworkConnected(c)){
            callback.back("",FALENT_NET_HTTP,method);
            return;
        }
        switch (sendType){
            case POST:
                Logger.e(url+map.toString());
                OkHttpUtils.post()
                        .params(map)
                        .url(url)
                        .tag(c)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e) {
                                callback.back("",FALENT_HTTP,method);
                                Logger.e(e.toString());
                            }

                            @Override
                            public void onResponse(String response) {
                                // 判断  是否为Json 数据
                                if (JsonUtils.isJson(response)){
                                    callback.back(response,SUCCESS_HTTP,method);
                                }else{
                                    callback.back("",FALENT_JSON_HTTP,method);
                                }
                                Logger.e(response);
                            }
                        });
                break;
            case GET:
                OkHttpUtils.get()
                        .params(map)
                        .url(url)
                        .tag(c)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e) {
                                callback.back("",FALENT_HTTP,method);
                                Logger.e(e.toString());
                            }

                            @Override
                            public void onResponse(String response) {
                                if (JsonUtils.isJson(response)){
                                    callback.back(response,SUCCESS_HTTP,method);
                                }else{
                                    callback.back("",FALENT_JSON_HTTP,method);
                                }
                                Logger.e(response);
                            }
                        });
                break;
            default:
                break;
        }
    }

    public interface ObserverCallBack{
        /**
         * @param data  返回的数据
         * @param encoding  是否请求成功
         * @param method  判断 是哪个接口返回的数据
         */
        void back(String data,int encoding,int method);
    }

}
