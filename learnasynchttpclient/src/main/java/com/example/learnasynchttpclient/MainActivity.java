package com.example.learnasynchttpclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String indexNovelUrl = "http://www.piaotian.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AsyncHttpClient client = new AsyncHttpClient();
        client.get(indexNovelUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Log.d(TAG, "onSuccess: " + statusCode);
                    for (int i = 0; i < headers.length; i++) {
                        Header header = headers[i];
                        String name = header.getName();
                        if ("Content-Type".equals(name)) {
                            String value = header.getValue();
                            int beginIndex = value.indexOf("=");
                            if (beginIndex != -1) {
                                String charset = value.substring(beginIndex + 1);
                                Log.d(TAG, "onSuccess: " + "name=" + name + " value=" + value);
                                Log.d(TAG, "onSuccess: " + charset);
                                String result = new String(responseBody, charset);
                                Log.d(TAG, "onSuccess: " + result);
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
}
