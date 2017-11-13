package com.ybe.ybeframes.utils;

import com.google.gson.Gson;

/**
 * Created by lhh on 2017/11/9.
 *  gson 解析
 */

public class GsonUtils {

    private static Gson gson = null;

    static {
        if (gson == null){
            gson =new Gson();
        }
    }

    private GsonUtils(){
    }

    /**
     *   Gson 转 Json
     * @param gsonStr
     * @return
     */
    public static String isJson(String gsonStr){
        String  json = null;
        if (gsonStr != null){
            json = gson.toJson(gsonStr);
        }
        return json;
    }

}
