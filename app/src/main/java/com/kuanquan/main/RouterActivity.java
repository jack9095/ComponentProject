package com.kuanquan.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Wiki on 16/7/28.
 */
public class RouterActivity {
    public static void openMainActivity(Context context,int uid, int age, long time) {
        Intent intent = new Intent();
        intent.putExtra("uid", uid);
        intent.putExtra("age", age);
        intent.putExtra("time", time);
        if (!(context instanceof Activity)){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
