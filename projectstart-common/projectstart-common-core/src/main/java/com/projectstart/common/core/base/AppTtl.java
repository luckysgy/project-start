package com.projectstart.common.core.base;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 请求ttl
 * ttl: TransmittableThreadLocal
 * @author shenguangyang
 * @date 2021-10-10 8:53
 */
public class AppTtl {
    private static final TransmittableThreadLocal<AppContext> ttl = new TransmittableThreadLocal<>();

    public static AppContext get() {
        AppContext context = ttl.get();
        if (context == null) {
            synchronized (AppTtl.class) {
                context = new AppContext();
                set(context);
            }
        }
        return context;
    }

    public static void set(AppContext context) {
        ttl.set(context);
    }

}
