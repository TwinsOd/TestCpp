package com.twinsod.testcpp;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionUtils {
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION = 2;

    private PermissionUtils() {
        //empty
    }

    //region Check permission for use camera, write and read of external storage and location for android 6.0
    public static void checkCameraPermission(Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
            }
        }
    }

    public static void checkWriteExternalPermission(Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION);
            }
        }
    }

    public static void checkAllPermission(Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION);
            }
        }
    }
}
