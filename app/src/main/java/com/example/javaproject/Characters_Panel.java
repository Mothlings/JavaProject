package com.example.javaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.content.ContextCompat;

public class Characters_Panel extends AppCompatActivity implements View.OnClickListener{
    Button bTimer;
    String time="boo";
    boolean isOn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        bTimer = (Button) findViewById(R.id.bTimer);

        bTimer.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bTimer:
                Timer();
                break;

        }
    }
}