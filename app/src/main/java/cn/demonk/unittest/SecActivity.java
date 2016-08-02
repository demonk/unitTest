package cn.demonk.unittest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by ligs on 8/2/16.
 */
public class SecActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstance) {
        Intent intent = getIntent();
        Log.e("demonk", intent.toString());
        super.onCreate(savedInstance);
        this.setContentView(R.layout.sec_main);
    }

    protected void onResume() {
        super.onResume();
        String a = null;
        Log.e("demonk", a);
        innerCall();
    }

    public void innerCall() {
        System.out.println("onresult");
    }
}
