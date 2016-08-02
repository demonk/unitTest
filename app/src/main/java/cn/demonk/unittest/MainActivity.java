package cn.demonk.unittest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_test = (Button) findViewById(R.id.button);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SecActivity.class));
                try {
                    write();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void write() throws Exception {
        File sd = Environment.getExternalStorageDirectory();
        FileOutputStream output = new FileOutputStream(new File(sd, "test"));

        output.write("test".getBytes());

        output.flush();
        output.close();
    }

}
