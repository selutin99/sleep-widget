package com.galua.sleepwidget.service;

import android.content.Context;

@FunctionalInterface
public interface ModeChanger {
    void updateMode(Context context, boolean isSleepingMode);
}
