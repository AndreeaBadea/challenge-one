package com.playtika.java.academy.challenge1.badea.andreea.powerups;

import com.playtika.java.academy.challenge1.badea.andreea.powerups.enums.ShieldType;

import java.util.function.IntSupplier;

public class BonusShield extends Shield{

    protected boolean isAdvantage;
    private int score;
    private String name;
    private ShieldType type;

    public BonusShield(int score, String name, ShieldType type) {
        this.score = score;
        this.name = name;
        this.type = type;
    }

    public boolean isAdvantage() {
        if(type.getSpecialAbility().equals("Invisible")){
            return true;
        }
        return false;
    }

    public void useBonusPoints(IntSupplier supplier){
        score += supplier.getAsInt();
    }

    @Override
    public void takesAHit(int damage) {
        score =  score - damage;
    }

    @Override
    public void hits(int points) {
        score = score + points;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public ShieldType getType() {
        return type;
    }

    public void setScore(int score) {
        this.score = score;
    }



    @Override
    public String toString() {
        return "BonusShield{" +
                "isAdvantage=" + isAdvantage +
                ", score=" + score +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
