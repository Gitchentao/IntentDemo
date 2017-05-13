package com.edu.zhaolong.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.edu.zhaolong.intentdemo.javaclass.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity"+getTaskId());
        setContentView(R.layout.activity_main);



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_id:
                String data = "嘿嘿";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // intent向SecondActivity传递数据
                // intent.putExtra("extra_data", data);
                // startActivity(intent);
                // startActivityForResult方法能在活动销毁的时候给上一个活动返回一个结果，它有两个参数，第一个是intent,第二个是请求码

                // 使用Bundle和intent向SecondActivity传递数据
                Bundle bundle = new Bundle();
                bundle.putString("data_key",data);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
                break;
        }
    }

    /**
     * 在SecondActivity销毁后回调该方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                // 判断secondActivity处理结果是否成功
                if(resultCode==RESULT_OK){
                    String resultData = data.getStringExtra("return_data");
                    Toast.makeText(this, ""+resultData, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
}
