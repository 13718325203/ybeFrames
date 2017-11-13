package com.ybe.ybeframes.activity;

import android.widget.TextView;

import com.ybe.ybeframes.R;
import com.ybe.ybeframes.activity.base.BaseActivity;
import com.ybe.ybeframes.http.HttpMethodUtil;
import com.ybe.ybeframes.http.UrlConfig;

import butterknife.Bind;

/**
 *  http://blog.csdn.net/u013564742/article/details/52771740
 *
 *  README.md 是一种文本格式:http://blog.sina.com.cn/s/blog_4ddef8f80102v19t.html
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.city_tv)
    TextView city_tv;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        HttpMethodUtil.city_list(ctx,this);
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void backSuccess(String data, int method) {
        super.backSuccess(data, method);
        switch (method){
            case UrlConfig.HTTP_CITY_LIST:

                break;
            default:
                break;
        }
    }
}
