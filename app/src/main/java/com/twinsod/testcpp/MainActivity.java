package com.twinsod.testcpp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("opencv_java3");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Tutorial1Activity.class));
                startActivity(new Intent(MainActivity.this, Tutorial2Activity.class));
//                startActivity(new Intent(MainActivity.this, CameraTestActivity.class));
            }
        });

        if (!OpenCVLoader.initDebug()){
            tv.setText(tv.getText() + "\n OpenCVLoader.initDebug(), not working.");
        }else {
            tv.setText(tv.getText() + "\n OpenCVLoader.initDebug(), Working.");
            //DRS
            tv.setText(tv.getText() + "\n" + validate(0L, 0L));
        }
        PermissionUtils.checkAllPermission(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String validate(long matAddrGr, long matAddrRgba);
}
