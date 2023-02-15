package com.factoriaf5.kata;

public class Character {
    

private int initHealth = 1000;
private int actualHealth = initHealth;
private int initDamage = 200;
private int actualDamage = initDamage;
private int initSanation = 50;
private int actualSanation = initSanation;
private int initLevel = 1;
private int actualLevel = initLevel;
private boolean alive = true;
private int distanceEnemy;
private int range;
private Faction faction; 


public int getRange() {
    return range;
}

public void setRange(int range) {
    this.range = range;
}

public void setDistanceEnemy( int distanceEnemy ) {
    this.distanceEnemy = distanceEnemy;
}

public int getDistanceEnemy() {
    return distanceEnemy;
}

public boolean canAttackRange() {
    if (getDistanceEnemy() <= range) {
        return true;
    }
    return false;
}


public Character() {
    this.initHealth = getInitHealth();
    this.actualHealth = getActualHealth();
    this.initDamage = getInitDamage();
    this.actualDamage = getActualDamage();
    this.initSanation = getInitSanation();
    this.actualSanation = getActualSanation();
    this.initLevel = getInitLevel();
    this.actualLevel = getActualLevel();
    this.alive = isAlive();
    this.faction = null;
}


public Faction getFaction() {
    return faction;
}

public void setFaction(Faction faction) {
    this.faction = faction;
}

public int getInitHealth() {
    return initHealth;
}
public void setInitHealth(int initHealth) {
    this.initHealth = initHealth;
}
public int getActualHealth() {
    return actualHealth;
}
public void setActualHealth(int actualHealth) {
    this.actualHealth = actualHealth;
}
public int getInitDamage() {
    return initDamage;
}
public void setInitDamage(int initDamage) {
    this.initDamage = initDamage;
}
public int getActualDamage() {
    return actualDamage;
}
public void setActualDamage(int actualDamage) {
    this.actualDamage = actualDamage;
}
public int getInitSanation() {
    return initSanation;
}
public void setInitSanation(int initSanation) {
    this.initSanation = initSanation;
}
public int getActualSanation() {
    return actualSanation;
}
public void setActualSanation(int actualSanation) {
    this.actualSanation = actualSanation;
}
public int getInitLevel() {
    return initLevel;
}
public void setInitLevel(int initLevel) {
    this.initLevel = initLevel;
}
public int getActualLevel() {
    return actualLevel;
}
public void setActualLevel(int actualLevel) {
    this.actualLevel = actualLevel;
}
public boolean isAlive() {
    return alive;
}
public void setAlive(boolean alive) {
    this.alive = alive; 
}
public boolean canAttack(Character target) {
    return this.faction != target.getFaction();
}

public void attackCharacter(Character character) {
    if(this.equals(character)) return;
    if(character.getFaction() != null && this.getFaction() != null && this.getFaction().getName().equals(character.getFaction().getName())) return;

    double damageActual = getActualDamage();
    if(character.getActualLevel() - this.getActualLevel() > 5){
        damageActual = getActualDamage() * 0.5;
    }
    if(this.getActualLevel() - character.getActualLevel() > 5){
        damageActual = getActualDamage() * 1.5;
    }
    character.actualHealth -= damageActual;
    character.setActualHealth(character.actualHealth);
    if(character.actualHealth <= 0){
        this.actualHealth = 0;
        setActualHealth(character.actualHealth);
        character.setAlive(false);
    }

}

public void healCharacter(Character character) {
    if(character.getFaction() != null && this.getFaction() != null && this.getFaction().getName().equals(character.getFaction().getName())){
    if(character.actualHealth > 0 && character.actualHealth < 1000){
    character.actualHealth += character.initSanation; 
    }}
    setActualHealth(character.actualHealth);
}

}
