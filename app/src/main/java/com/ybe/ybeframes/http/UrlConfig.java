package com.ybe.ybeframes.http;

/**
 * Created by lhh on 2017/11/13.
 */

public class UrlConfig {

    public static final String HTTP = HttpUrl.HTTP;
    public static final String PATH = HttpUrl.PATH;

    public static final String ROOT_URL = HTTP + PATH + "/index.php/";

    /**
     * 3.1获取城市列表
     */
    public static final String TC_CITY_LIST = ROOT_URL + "Home/Common/city_list.html";
    public static final int HTTP_CITY_LIST = 1000001;

}
