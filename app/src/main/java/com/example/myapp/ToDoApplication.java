package com.example.myapp;

import android.app.Application;
import timber.log.Timber;

public class ToDoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}