package com.example.froute.lib;

/**
 * Created by fei.wang on 2018/9/1.
 * 拦截器
 */
public interface Interceptor {
    /**
     * return true to intercept executor  true 表示拦截器执行了
     * @param intentWrapper the intent wrapper
     * @return
     */
    boolean intercept(IntentWrapper intentWrapper);
}
