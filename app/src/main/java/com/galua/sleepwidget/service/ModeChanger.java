package com.galua.sleepwidget.service;

@FunctionalInterface
public interface ModeChanger {
    void updateMode(boolean isSleepingMode);
}
