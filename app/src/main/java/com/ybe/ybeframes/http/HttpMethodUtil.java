package com.ybe.ybeframes.http;

import android.content.Context;

import com.ybe.ybeframes.utils.AppUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhh on 2017/11/13.
 * 请求数据
 */

public class HttpMethodUtil {

    /**
     * 公有方法  version版本号 & model类型（1 android  2 ios）
     *
     * @param context
     * @return
     */
    private static Map<String, String> getHttpVersionName(Context context) {
        Map<String, String> params = new HashMap<>();
        params.put("version_name", AppUtils.getCurrentVersion(context).versionName + "");
        params.put("model_type", "1");
        return params;
    }

    /**
     * 3.1获取城市列表
     */
    public static void city_list(Context c, AnsynHttpRequest.ObserverCallBack callback) {
        Map<String, String> params = getHttpVersionName(c);
        AnsynHttpRequest.requestHttp(c, AnsynHttpRequest.POST, params, UrlConfig.TC_CITY_LIST, callback, UrlConfig.HTTP_CITY_LIST);
    }

}
