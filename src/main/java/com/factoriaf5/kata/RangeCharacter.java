package com.factoriaf5.kata;

public class RangeCharacter extends Character {


    public RangeCharacter(int distanceEnemy) {
        setRange(20); 
        setDistanceEnemy(distanceEnemy);
    }

    public boolean canAttackRange(){
        if(getDistanceEnemy() <= getRange()){
            return true;
        }
        return false ;
    }

    @Override
    public void attackCharacter(Character character) {
        if (canAttackRange()) {
            super.attackCharacter(character);
        }
    }

    public void atttackCharactersam() {
    }

    public void atttackCharacte(MyCharacter sam) {
    }

}