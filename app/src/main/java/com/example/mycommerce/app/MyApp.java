package com.example.mycommerce.app;

import android.app.Application;
import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;
import com.example.mycommerce.utils.MyFileNameGenerator;

public class MyApp  extends Application {
    public static Context app;

    private HttpProxyCacheServer proxy;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer.Builder(this)
                .maxCacheSize(1024 * 1024 * 1024)
                .maxCacheFilesCount(30)
                .fileNameGenerator(new MyFileNameGenerator())
                .build();
    }
}
