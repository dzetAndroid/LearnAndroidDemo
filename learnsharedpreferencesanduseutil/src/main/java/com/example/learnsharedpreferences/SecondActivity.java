package com.example.learnsharedpreferences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: 1" + getLocalClassName());
        Log.d(TAG, "onCreate: 2" + getClass().getName());
        Log.d(TAG, "onCreate: 3" + getClass().getSimpleName());



    }
}
