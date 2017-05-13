package com.edu.zhaolong.intentdemo.javaclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by CHEN on 2017/5/13.
 */

public class BaseActivity extends AppCompatActivity{
    private static final String TAG = "BaseActivity";

    /**
     * 知晓当前是哪一个Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获取当前实例的类名
        Log.d(TAG, "BaseActivity"+getClass().getSimpleName());
        // 将当前正在创建的活动添加到管理器中
        ActivityCollector.addActivity(this);
    }

    /**
     * 马上要销毁一个活动从活动管理器中移除
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
