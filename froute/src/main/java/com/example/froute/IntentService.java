package com.example.froute;

import com.example.froute.lib.IntentWrapper;
import com.example.froute.lib.annotations.ClassName;
import com.example.froute.lib.annotations.Key;
import com.example.froute.lib.annotations.RequestCode;

/**
 * Created by fei.wang on 2018/9/1.
 *
 */
public interface IntentService {
    @ClassName("com.example.livedata.MainActivity")
    @RequestCode(100)
    void intent2ActivityDemo2(@Key("platform") String platform, @Key("year") int year);

    @ClassName("android.router.literouter.ActivityDemo2")
    IntentWrapper intent2ActivityDemo2Raw(@Key("platform") String platform, @Key("year") int year);
}
