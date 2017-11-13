package com.ybe.ybeframes.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lhh  on 2017/11/9
 *   json 解析工具类
 */

public class JsonUtils {

    /**
     *  判断是否为 json 数据
     * @param json
     * @return
     */
    public static boolean  isJson(String json){
        boolean isJson = false;
        try {
            JSONObject  jsonObject=new JSONObject(json);
            isJson = true;
        } catch (JSONException e) {
            isJson = false;
        }
        return isJson;
    }

}
