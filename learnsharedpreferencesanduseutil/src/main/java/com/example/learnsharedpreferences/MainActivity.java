package com.example.learnsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getLocalClassName() 和 getClass().getSimpleName() 输出结果一样（MainActivity）
//        Log.d(TAG, "onCreate: 1" + getLocalClassName());
//        Log.d(TAG, "onCreate: 2" + getClass().getName());
//        Log.d(TAG, "onCreate: 3" + getClass().getSimpleName());

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String key01 = "key01";
        String defaultValue = "default";
        boolean contains = preferences.contains(key01);
        if (contains) {
            String value = preferences.getString(key01, defaultValue);
            Log.d(TAG, "onCreate: " + contains);
            Log.d(TAG, "onCreate: " + value);
        } else {
            SharedPreferences.Editor edit = preferences.edit();
            edit.putString(key01, "55667ss").apply();

            String value = preferences.getString(key01, defaultValue);
            Log.d(TAG, "onCreate: " + contains);
            Log.d(TAG, "onCreate: " + value);
        }


        // tray 使用
//        String key = "high";
//        boolean b = GlobalField.getAppPreferences(this).contains(key);
//        if (b){
//            int value = GlobalField.getAppPreferences(this).getInt(key, 0);
//            Log.d(TAG, "onCreate: " + b);
//            Log.d(TAG, "onCreate: " + value);
//        }else {
//            GlobalField.getAppPreferences(this).put(key, 456);
//            int value = GlobalField.getAppPreferences(this).getInt(key, 0);
//            Log.d(TAG, "onCreate: " + b);
//            Log.d(TAG, "onCreate: " + value);
//        }

        // easysp 使用
//        String key2 = "hi";
//        boolean bool = EasySP.init(this).contains(key2);
//        if (bool) {
//            int value = EasySP.init(this).getInt(key2);
//            Log.d(TAG, "onCreate: " + bool);
//            Log.d(TAG, "onCreate: " + value);
//        } else {
//            EasySP.init(this).putInt(key2, 256);
//            int value = EasySP.init(this).getInt(key2);
//            Log.d(TAG, "onCreate: " + bool);
//            Log.d(TAG, "onCreate: " + value);
//        }

    }
}
