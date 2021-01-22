package com.czt.sdgrocord;

import android.app.Application;
import com.czt.mp3recorder.Mp3RecorderUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Mp3RecorderUtil.init(this, true);
    }
}
