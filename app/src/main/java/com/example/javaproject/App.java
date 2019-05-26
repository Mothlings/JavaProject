package com.example.javaproject;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.ArrayList;

public class App extends Application {
    public static final String CHANNEL_ID = "exampleServiceChannel";
    public ArrayList<Character> characters;

    public App(){
        characters = new ArrayList<Character>();
    }

    public App(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public void onCreate() {
        characters= new ArrayList<Character>();
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //if on oreo or lower version
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Example Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}