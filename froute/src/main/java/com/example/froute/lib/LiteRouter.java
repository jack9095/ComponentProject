package com.example.froute.lib;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fei.wang on 2018/9/1.
 *
 */
public final class LiteRouter {
    private Interceptor interceptor;

    LiteRouter(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    /**
     * create router class service
     *
     * @param service router class
     * @param context from context
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> service, final Context context) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object... args)
                            throws Throwable {
                        IntentWrapper intentWrapper = loadIntentWrapper(context, method, args);

                        Class returnTYpe = method.getReturnType();
                        if (returnTYpe == void.class) {
                            if (interceptor == null || !interceptor.intercept(intentWrapper)) {
                                intentWrapper.start();
                            }
                            return null;
                        } else if (returnTYpe == IntentWrapper.class) {
                            return intentWrapper;
                        }
                        throw new RuntimeException("method return type only support 'void' or 'IntentWrapper'");
                    }
                });
    }

    IntentWrapper loadIntentWrapper(Context context, Method method, Object... args) {
        return new IntentWrapper.Builder(context, method, args).build();
    }

    public static final class Builder {
        private Interceptor interceptor;

        public Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        public LiteRouter build() {
            return new LiteRouter(interceptor);
        }
    }
}
