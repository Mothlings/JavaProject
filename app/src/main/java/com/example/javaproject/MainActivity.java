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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,RecycleAdapter.OnItemListener{
    Button bClockSettings, bAddCharacter;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //private ArrayList<Character> charList;

    App app;
    Character c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //charList = new ArrayList<Character>();
         c = new Character();
        app = (App) getApplication();
        /*
        for (Character a:app.charList.characters)
        {
            c=a;
            charList.add(c);

        }*/
        bAddCharacter =(Button) findViewById(R.id.bAddCharacter);
        bClockSettings = (Button) findViewById(R.id.bClockSettings);

        bClockSettings.setOnClickListener(this);
        bAddCharacter.setOnClickListener(this);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        mAdapter = new RecycleAdapter(app.charList.characters, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        Character kurc = new Character();
        app.charList.characters.add(kurc);

        //app.charList.characters.get(0);
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



    @Override
    public void onItemClick(int position) {
        app.idApp = app.charList.get(position).getId();
        Intent j = new Intent(this, Characters_Panel.class);
        startActivityForResult(j, 1);
    }
}