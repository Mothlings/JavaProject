package com.example.javaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.google.gson.Gson;

public class Characters_Panel extends AppCompatActivity implements View.OnClickListener{
    Button bTimer, bSave, bBack;
    TextView tName, tLevel, tComment;
    String time="boo";
    boolean isOn=false;
    App app;
    Character c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        bTimer = (Button) findViewById(R.id.bTimer);
        bSave = (Button) findViewById(R.id.bSaveChanges);
        bBack = (Button) findViewById(R.id.bBack);

        bTimer.setOnClickListener(this);
        bSave.setOnClickListener(this);
        bBack.setOnClickListener(this);

        tName = (TextView) findViewById(R.id.tName);
        tLevel = (TextView) findViewById(R.id.tLevel);
        tComment = (TextView) findViewById(R.id.tComment);

        app = (App) getApplication();

        for (Character a:app.charList.characters) {
            if(app.getIdApp() == a.getId()){
                c = a;
            }
        }
        tName.setText(c.getName());
        tLevel.setText(c.getLevel());
        tComment.setText(c.getCommnet());
    }

    public void Timer(){
        if(isOn){
            isOn=false;
            Intent serviceIntent = new Intent(this, Timer_Service.class);

            bTimer.setText("Start timer");

        }
        else {
            isOn = true;
            Intent serviceIntent = new Intent(this, Timer_Service.class);
            serviceIntent.putExtra("inputExtra", time);
            ContextCompat.startForegroundService(this, serviceIntent);

            bTimer.setText("Stop timer");
        }
    }
    public void SaveChangers(){

        for (Character a:app.charList.characters) {
            if(app.getIdApp() == c.getId()){
                a.setCommnet(tComment.getText().toString());
                a.setName(tName.getText().toString());
                a.setLevel(tLevel.getText().toString());
            }
        }
        Intent returnIntent = new Intent();
        setResult(MainActivity.RESULT_CANCELED, returnIntent);
       // SaveGson();
        finish();

    }
    public void SaveGson(){
        Gson gson = new Gson();
        String json = gson.toJson(app);
        System.out.println(json);
    }

    public void Back(){
        Intent returnIntent = new Intent();
        setResult(MainActivity.RESULT_CANCELED, returnIntent);
        finish();
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bTimer:
                Timer();
                break;
            case R.id.bSaveChanges:
                SaveChangers();
                break;
            case R.id.bBack:
                Back();
                break;
        }
    }
}