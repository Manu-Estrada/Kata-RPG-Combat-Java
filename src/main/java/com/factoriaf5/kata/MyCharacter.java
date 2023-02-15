package com.factoriaf5.kata;

public class MyCharacter extends Character{
    
    
    public MyCharacter(int distanceEnemy) {
        setRange(2); 
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
        if(canAttackRange()){
            super.attackCharacter(character);
        }
    }
}
    

