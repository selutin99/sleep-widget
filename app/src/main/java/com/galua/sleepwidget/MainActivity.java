package com.galua.sleepwidget;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.galua.sleepwidget.service.impl.Constants;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
    }


    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Permissions.check(
                this,
                Constants.PERMISSIONS_LIST.toArray(new String[0]),
                Constants.PERMISSIONS_RATIONALE,
                Constants.PERMISSIONS_OPTIONS,
                new PermissionHandler() {
                    @Override
                    public void onGranted() {
                    }
                }
            );
        }
    }
}
