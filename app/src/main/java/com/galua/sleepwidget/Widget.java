package com.galua.sleepwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class Widget extends AppWidgetProvider {

    private static final String SYNC_CLICKED = "WidgetImageClick";
    private static boolean IS_SLEEPING_MODE = false;

    private final PresentorUtils presentorUtils = new PresentorUtils();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        presentorUtils.configurePresentor(context);

        presentorUtils.getRemoteViews().setImageViewResource(R.id.imageView, presentorUtils.setImage(IS_SLEEPING_MODE));
        presentorUtils.getRemoteViews().setOnClickPendingIntent(R.id.imageView, presentorUtils.getPendingSelfIntent(context, SYNC_CLICKED));

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

}
