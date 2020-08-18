package com.galua.sleepwidget.service.impl;

import android.Manifest;


import com.nabinbhandari.android.permissions.Permissions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {
    //region day mode
    public static final int DAY_BRIGHT = 255;
    public static final int DAY_VOLUME = 100;
    //endregion

    //region night mode
    public static final int NIGHT_BRIGHT = 30;
    public static final int NIGHT_VOLUME = 0;
    //endregion

    //region permissions
    public static final Permissions.Options PERMISSIONS_OPTIONS = new Permissions.Options()
            .setRationaleDialogTitle("Info")
            .setSettingsDialogTitle("Warning");
    public static final String PERMISSIONS_RATIONALE = "Please provide permission for widget using...";
    public static final List<String> PERMISSIONS_LIST = Collections.unmodifiableList(Arrays.asList(
        Manifest.permission.WRITE_SETTINGS,
        Manifest.permission.ACCESS_NOTIFICATION_POLICY
    ));
    //endregion
}
