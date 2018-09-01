package com.example.froute.lib;

/**
 * Created by fei.wang on 2018/9/1.
 *
 */
public interface Interceptor {
    /**
     * return true to intercept executor
     * @param intentWrapper the intent wrapper
     * @return
     */
    boolean intercept(IntentWrapper intentWrapper);
}
