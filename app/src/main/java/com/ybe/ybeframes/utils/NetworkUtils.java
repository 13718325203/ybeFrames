package com.ybe.ybeframes.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by lhh on 2017/11/9.
 *   网络 工具类
 */

public class NetworkUtils {

    /**
     *  判断 是否 有网络
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context){
        if (context != null){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

}
