package com.example.javaproject;

import java.util.ArrayList;
import java.util.UUID;

public class Character {
    private int imageteam;
    private String name;
    private String level;
    private String startTime;
    private String endTime;
    public String id;
    private String commnet;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
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

    public String getId() {
        return id;
    }

    public String getCommnet() {
        return commnet;
    }

    public Character() {
        this.imageteam = -1;
        this.name = "?";
        this.level = "?";
        this.startTime = "?";
        this.endTime = "?";
        this.timer = "?";
        this.commnet = "?";
        this.id= UUID.randomUUID().toString().replace("-", "");
    }

    public Character(int imageteam, String name, String level, String startTime, String endTime, String commnet) {
        this.imageteam = imageteam;
        this.name = name;
        this.level = level;
        this.startTime = startTime;
        this.endTime = endTime;
        this.commnet = commnet;
    }



}