package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactionTest {

    private RangeCharacter harry = new RangeCharacter(12);
    private MyCharacter sam = new MyCharacter(2);
    private MyCharacter wilson = new MyCharacter(2);
    Faction archers = new Faction("archers");
    Faction strikers = new Faction("strikers");
    

    public FactionTest() {
        strikers.addCharacter(sam);
        strikers.addCharacter(wilson);
    }

    @Test
    void add_character_faction() {
        archers.addCharacter(harry);
        assertEquals("archers", harry.getFaction().getName());
    }

    @Test
    void character_dont_attack_allies() {
        sam.attackCharacter(wilson);
        assertEquals(1000, wilson.getActualHealth());
    }

    @Test
    void character_attack() {
        harry.attackCharacter(sam);
        assertEquals(800, sam.getActualHealth());
    }

    @Test
    void enemys_cant_heal(){
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        harry.healCharacter(sam);
        assertEquals(600, sam.getActualHealth());
    }

    @Test
    void allies_can_heal(){
        harry.attackCharacter(sam);
        harry.attackCharacter(sam);
        wilson.healCharacter(sam);
        assertEquals(650, sam.getActualHealth());
    }

}