package com.example.javaproject;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {
    public static final String CHANNEL_ID = "exampleServiceChannel";
    public static final String TAG = MainActivity.class.getSimpleName();

    public Characters charList;
    public String idApp;
    private Gson gson;
    private File file;

    public App(){
      //  charList.characters = new ArrayList<Character>();
    }

    public App(Characters charList) {
        this.charList = charList;
    }

    public Characters getCharList() {
        return charList;
    }

    public String getIdApp() {
        return idApp;
    }

    public void setCharList(Characters charList) {
        this.charList = charList;
    }

    public void setIdApp(String idApp) {
        this.idApp = idApp;
    }

    @Override
    public void onCreate() {
        charList = new Characters();
        charList.characters= new ArrayList<Character>();
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

    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().setPrettyPrinting().create();
        }
        return gson;
    }

    private File getFile() {
        if (file == null) {
            File filesDir = getFilesDir();
            file = new File(filesDir, "matches.json");
        }
        Log.i(TAG, file.getPath());
        return file;
    }

    public void saveToFile() {
        try {
            FileUtils.writeStringToFile(getFile(), getGson().toJson(charList));
        } catch (IOException e) {
            Log.d(TAG, "Can't save "+file.getPath());
        }
    }
    public boolean readFromFile() {
        if (!getFile().exists())  return false;
        try {
            charList = getGson().fromJson(FileUtils.readFileToString(getFile()) , Characters.class);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public void save() {
        saveToFile();
    }

}