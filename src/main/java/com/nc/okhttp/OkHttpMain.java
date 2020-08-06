package com.nc.okhttp;

import okhttp3.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class OkHttpMain {
    public static void main(String[] args) {
        String url = "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3305875542,1614979519&fm=26&gp=0.jpg";
        String url2 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2658877228,316034695&fm=26&gp=0.jpg";
         // 原生写法
        /*OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();*/
        // 静态工厂
        /*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OkHttpClient okHttpClient = ctx.getBean("okHttpClient", OkHttpClient.class);*/
        //实例工厂
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OkHttpClient okHttpClient = ctx.getBean("okHttpClient2", OkHttpClient.class);

        Request request = new Request.Builder()
                .get()
                .url(url2)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FileOutputStream out = new FileOutputStream(new File("D:\\StudyTest\\spring\\okhttp.jpg"));
                int len;
                byte[] buf = new byte[1024];
                InputStream is = response.body().byteStream();
                while ((len = is.read(buf)) != -1){
                    out.write(buf, 0, len);
                }
                out.close();
                is.close();
            }
        });
    }
}
