package com.example.javaproject;

import java.util.ArrayList;

public class Characters {
    public ArrayList<Character> characters;

    public Characters(ArrayList<Character> matches) {
        this.characters = matches;
    }

    public Characters() {
        this.characters = new ArrayList<Character>();
    }


    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public Character get(int pos){
        return characters.get(pos);
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }
}
