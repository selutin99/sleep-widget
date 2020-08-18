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

        invokeLogic(context);

        presentorUtils.getRemoteViews().setOnClickPendingIntent(R.id.imageView, presentorUtils.getPendingSelfIntent(context, SYNC_CLICKED));
        appWidgetManager.updateAppWidget(presentorUtils.getComponentName(), presentorUtils.getRemoteViews());
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (SYNC_CLICKED.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            invokeLogic(context);
            appWidgetManager.updateAppWidget(presentorUtils.getComponentName(), presentorUtils.getRemoteViews());
        }
    }

    private void invokeLogic(Context context) {
        presentorUtils.configurePresentor(context);

        presentorUtils.getRemoteViews().setImageViewResource(R.id.imageView, presentorUtils.setImage(IS_SLEEPING_MODE));
        IS_SLEEPING_MODE = !IS_SLEEPING_MODE;
    }

}

