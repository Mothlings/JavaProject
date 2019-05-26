package com.example.javaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bClockSettings, bAddCharacter;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    App app;
    Character c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         app = (App) getApplication();
        for (Character a:app.characters)
        {
                c = a;
        }

        bAddCharacter =(Button) findViewById(R.id.bAddCharacter);
        bClockSettings = (Button) findViewById(R.id.bClockSettings);

        bClockSettings.setOnClickListener(this);
        bAddCharacter.setOnClickListener(this);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

       mAdapter = new RecycleAdapter(app.characters);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Character kurc = new Character();
        app.characters.add(kurc);

        app.characters.get(0);
    }

    public void SettingClock(){
        Intent j = new Intent(this,Clock_Resource.class);
        startActivityForResult(j, 1);

    }

    public void AddCharacter() {
        Intent j = new Intent(this, Characters_Panel.class);
        startActivityForResult(j, 1);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bClockSettings:
                SettingClock();
                break;
            case R.id.bAddCharacter:
                AddCharacter();
                break;

        }
    }
}
