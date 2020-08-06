package com.nc.okhttp;

import okhttp3.OkHttpClient;

/*静态工厂*/
public class OkHttpUtils {
    private static OkHttpClient okHttpClient;
    public static OkHttpClient getInstance() {
        if(okHttpClient == null){
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
