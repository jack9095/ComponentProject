package com.example.livedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * https://blog.csdn.net/guiying712/article/details/55213884
 * https://blog.csdn.net/lulalei/article/details/80250028
 *
 * 自己快速写一个路由框架
 * https://www.jianshu.com/p/f966db1a0c08
 * https://www.jianshu.com/p/200c6cc6adaf
 * https://blog.csdn.net/H176Nhx7/article/details/81380458
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String platform = intent.getStringExtra("platform");
        int year = intent.getIntExtra("year", 0);
        Log.e("platform: ", platform);
        Log.e("year: ", String.valueOf(year));

        setResult(RESULT_OK);
    }
}
