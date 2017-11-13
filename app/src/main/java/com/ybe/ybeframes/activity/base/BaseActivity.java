package com.ybe.ybeframes.activity.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ybe.ybeframes.http.AnsynHttpRequest;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.ButterKnife;

/**
 * Created by lhh on 2017/11/8.
 * Activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity implements AnsynHttpRequest.ObserverCallBack {

    public String TAG = getClass().getSimpleName();
    public Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        ctx = this;
        initView();
        initListener();
        initData();
    }

    protected abstract int getLayoutResId();

    protected void initView() {

    }

    protected void initListener() {

    }

    protected void initData() {

    }

    @Override
    public void back(String data, int encoding, int method) {
        if (encoding == AnsynHttpRequest.SUCCESS_HTTP) {
            backSuccess(data, method);
        } else {
            String encodString = "";
            switch (encoding) {
                case AnsynHttpRequest.FALENT_HTTP:
                    encodString = "请求数据错误";
                    break;
                case AnsynHttpRequest.FALENT_NET_HTTP:
                    encodString = "请求网络错误";
                    break;
                case AnsynHttpRequest.FALENT_JSON_HTTP:
                    encodString = "解析Json数据错误";
                    break;
                default:
                    break;
            }
            Toast.makeText(this, "" + encodString, Toast.LENGTH_SHORT).show();
        }
    }

    protected void backSuccess(String data, int method) {

    }

    protected void backFail(String data, int method) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(this);//取消以Activity.this作为tag的请求
        ButterKnife.unbind(this);
    }
}
