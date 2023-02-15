package com.factoriaf5.kata;

import java.util.*;


public class Faction extends Character {
    private String name;
    private List<Character> characters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faction(String name) {
        this.name = name;
        this.characters = new ArrayList<Character>();
    }
    
    public void addCharacter(Character character){
        character.setFaction(this);
        this.characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}