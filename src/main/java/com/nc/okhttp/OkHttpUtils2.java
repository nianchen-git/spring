package com.nc.okhttp;

import okhttp3.OkHttpClient;

/*实例工厂*/
public class OkHttpUtils2 {
    private OkHttpClient okHttpClient;
    public OkHttpClient getInstance(){
        if(okHttpClient == null){
            okHttpClient = new OkHttpClient.Builder().build();
        }
        System.out.println("实例工厂");
        return okHttpClient;
    }

}
