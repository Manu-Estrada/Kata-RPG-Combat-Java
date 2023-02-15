package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    private RangeCharacter harry = new RangeCharacter(12);
    private MyCharacter sam = new MyCharacter(2);
    private MyCharacter wilson = new MyCharacter(2);
    Faction archers = new Faction("archers");
    Faction strikers = new Faction("strikers");

    public CharacterTest() {
        archers.addCharacter(harry);
        strikers.addCharacter(sam);
        strikers.addCharacter(wilson);
    }

    

    @Test
    public void Health_is_1000() {
        assertEquals(1000,harry.getInitHealth());
    }

    @Test
    public void level_is_1() {
        assertEquals(1,sam.getInitLevel());
    }

    @Test
    public void Character_Is_Alive() {
        assertEquals(true,sam.isAlive());
    }

    @Test
    public void  no_faction_default() {
        RangeCharacter harryneitor = new RangeCharacter(2);
        assertEquals(null,harryneitor.getFaction());
    }

    

    @Test
    public void checked_damage() {
        sam.attackCharacter(harry);
        assertEquals(800, harry.getActualHealth());
    }

    @Test
    public void character_is_die() {
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        assertEquals(false, sam.isAlive() );
    }

    @Test
    public void checked_sanation() {
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        sam.healCharacter(sam);
        assertEquals(450, sam.getActualHealth());
    } 

    @Test
    public void checked_damage_myself() {
        sam.attackCharacter(sam);
        assertEquals(1000, sam.getActualHealth());
    }

      @Test
    public void checked_damage_level() {
        harry.setActualLevel(100);
        wilson.setActualLevel(12);
        wilson.attackCharacter(harry);
        assertEquals(900, harry.getActualHealth());
    }

    @Test
    public void MyCharacter_can_attack() {
        wilson.attackCharacter(harry);
        
        assertEquals(800, harry.getActualHealth());
    }

    @Test
    public void Character_cant_attack() {
        MyCharacter miCharacter = new MyCharacter(3);
        Character youCharacter = new Character();  

        miCharacter.attackCharacter(youCharacter);
        
        assertEquals(1000, youCharacter.getActualHealth());
    }

    @Test
    public void RangeCharacter_can_attack() { 

        harry.attackCharacter(sam);
        
        assertEquals(800, sam.getActualHealth());
    }

    @Test
    public void RangeCharacter_cant_attack() {
        RangeCharacter miCharacter = new RangeCharacter(21);
        Character youCharacter = new Character();  

        miCharacter.attackCharacter(youCharacter);
        
        assertEquals(1000, youCharacter.getActualHealth());
    }
}