package com.dzet.demo01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "DisplayMessageActivity";

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);

        // 获取一个字符串   从资源目录中
        // 创建多个语言区域目录的好处
        // values   values-zh
        //
        // 显示字符串资源时，会根据当前手机本地语言做匹配
        // 就是说, 我当前的module提供了英文版和中文版

        // 那么，我在进行Log输出时，显示的就是中文
        String hello = getResources().getString(R.string.hello_world);
        Log.d(TAG, "onCreate: " + hello);

    }
}
