package com.edu.zhaolong.intentdemo;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.edu.zhaolong.intentdemo.javaclass.ActivityCollector;
import com.edu.zhaolong.intentdemo.javaclass.BaseActivity;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "ThirdActivity"+getTaskId());
        setContentView(R.layout.activity_third);

        Button button = (Button) findViewById(R.id.dropout_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
                // 杀死当前进程
                android.os.Process.killProcess(Process.myPid());
            }
        });
    }
}
