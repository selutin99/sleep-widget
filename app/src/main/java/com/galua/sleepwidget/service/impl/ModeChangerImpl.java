package com.galua.sleepwidget.service.impl;

import android.content.Context;
import android.media.AudioManager;

import com.galua.sleepwidget.Constants;
import com.galua.sleepwidget.service.ModeChanger;

public class ModeChangerImpl implements ModeChanger {

    @Override
    public void updateMode(Context context, boolean isSleepingMode) {
        changeScreenBrightness(context, isSleepingMode);
        changeSystemVolume(context, isSleepingMode);
    }

    private void changeScreenBrightness(Context context, boolean isSleepingMode) {
        android.provider.Settings.System.putInt(
            context.getContentResolver(),
            android.provider.Settings.System.SCREEN_BRIGHTNESS,
            isSleepingMode ? Constants.DAY_BRIGHT : Constants.NIGHT_BRIGHT
        );
    }

    private void changeSystemVolume(Context context, boolean isSleepingMode) {
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, isSleepingMode ? Constants.DAY_VOLUME : Constants.NIGHT_VOLUME, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        audioManager.setStreamVolume(AudioManager.STREAM_RING, isSleepingMode ? Constants.DAY_VOLUME : Constants.NIGHT_VOLUME, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        audioManager.setStreamVolume(AudioManager.STREAM_ALARM, Constants.DAY_VOLUME, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        audioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, isSleepingMode ? Constants.DAY_VOLUME : Constants.NIGHT_VOLUME, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, isSleepingMode ? Constants.DAY_VOLUME : Constants.NIGHT_VOLUME, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
    }
}
