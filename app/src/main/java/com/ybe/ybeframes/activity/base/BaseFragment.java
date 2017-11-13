package com.ybe.ybeframes.activity.base;

import android.app.Fragment;

import com.ybe.ybeframes.http.AnsynHttpRequest;

/**
 * Created by lhh on 2017/11/13
 */

public class BaseFragment extends Fragment  implements AnsynHttpRequest.ObserverCallBack {

    @Override
    public void back(String data, int encoding, int method) {

    }

}
