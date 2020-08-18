package com.galua.sleepwidget;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import lombok.Getter;

@Getter
public class PresentorUtils {

    private RemoteViews remoteViews;
    private ComponentName componentName;

    public void configurePresentor(Context context) {
        remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
        componentName = new ComponentName(context, Widget.class);
    }

    public int setImage(boolean isSleepingMode) {
        return isSleepingMode ? R.drawable.day : R.drawable.night;
    }

    public PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, Widget.class);
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
}
