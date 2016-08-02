package cn.demonk.unittest;

import android.app.Application;
import android.util.Log;

/**
 * Created by ligs on 8/2/16.
 */
public class CustomApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Log.e("demonk", "oncreate");
    }
}
