package com.playtika.java.academy.challenge1.badea.andreea.powerups;

import com.playtika.java.academy.challenge1.badea.andreea.powerups.enums.ShieldType;

public class BrokenShield extends  BonusShield{
    private int additionalDamage;

    public BrokenShield(int score, String name, ShieldType type, int additionalDamage) {
        super(score, name, type);
        this.additionalDamage = additionalDamage;
    }

    public void disable(){
        additionalDamage = 0;
    }

    @Override
    public void takesAHit(int damage){
        int initialScore = getScore();
        setScore(initialScore - damage - additionalDamage);
    }

    @Override
    public void hits(int points){
        int initialScore = getScore();
        setScore(initialScore + points - additionalDamage);
    }


    @Override
    public String toString() {
        return " BrokenShield{ " +
                "isAdvantage=" + isAdvantage +
                ", score=" + getScore() +
                ", name='" + getName() + '\'' +
                ", type= " + getType() + '\'' +
                ", aditionalDamage=" + additionalDamage +
                '}';
    }

}
