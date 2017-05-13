package com.edu.zhaolong.intentdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.edu.zhaolong.intentdemo.javaclass.BaseActivity;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "SecondActivity"+getTaskId());
        setContentView(R.layout.activity_second);
       // 接收MainActivity活动传递的数据
        Intent intent = getIntent();
        String data = intent.getStringExtra("data_key");
        Log.d(TAG, "onCreate: " + data);
        Toast.makeText(this, "" + data, Toast.LENGTH_SHORT).show();

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_id1:
                // 返回数据到MainActivity活动
//                Intent intent1 = new Intent();
//                intent1.putExtra("return_data", "哈哈哈哈哈哈");
//                setResult(RESULT_OK,intent1);
//                finish();
                SecondActivity.actionStart(SecondActivity.this,"","");
                break;
        }
    }

    /**
     * 当用户按下Back键，向MainActivity活动返回数据事件
     */
    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent();
        intent1.putExtra("return_data", "哈哈哈哈哈哈");
        setResult(RESULT_OK, intent1);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    /**
     * 跳转活动的最佳写法
     * @param context
     * @param data1
     * @param data2
     */
    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,ThirdActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }
}
