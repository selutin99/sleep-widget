package com.galua.sleepwidget.service.impl;

import android.content.Context;

import com.galua.sleepwidget.service.ModeChanger;

public class ModeChangerImpl implements ModeChanger {

    @Override
    public void updateMode(Context context, boolean isSleepingMode) {
        changeScreenBrightness(context, isSleepingMode);
    }

    private void changeScreenBrightness(Context context, boolean isSleepingMode) {
        android.provider.Settings.System.putInt(
            context.getContentResolver(),
            android.provider.Settings.System.SCREEN_BRIGHTNESS,
            isSleepingMode ? ModeConfig.DAY_BRIGHT : ModeConfig.NIGHT_BRIGHT
        );
    }
}
