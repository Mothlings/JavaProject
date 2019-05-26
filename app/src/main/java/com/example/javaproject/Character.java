package com.example.javaproject;

import java.util.ArrayList;

public class Character {
    private int imageteam;
    private String name;
    private String level;
    private String startTime;
    private String endTime;
    private String timer;


    public void setImageteam(int imageteam) {
        this.imageteam = imageteam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getImageteam() {
        return imageteam;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Character() {
        this.imageteam = -1;
        this.name = "?";
        this.level = "?";
        this.startTime = "?";
        this.endTime = "?";
        this.timer = "?";
    }

    public Character(int imageteam, String name, String level, String startTime, String endTime) {
        this.imageteam = imageteam;
        this.name = name;
        this.level = level;
        this.startTime = startTime;
        this.endTime = endTime;
    }



}
