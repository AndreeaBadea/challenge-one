package com.playtika.java.academy.challenge1.badea.andreea.powerups;

import com.playtika.java.academy.challenge1.badea.andreea.powerups.enums.ShieldType;

public class AdditionalGunShield extends BonusShield{
    private String ability;
    private int scoreMultiplier;


    public AdditionalGunShield(int score, String name, ShieldType type, String ability, int scoreMultiplier) {
        super(score, name, type);
        this.ability = ability;
        this.scoreMultiplier = scoreMultiplier;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }

    public void setScoreMultiplier(int scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    public void useAdditionalGun(){
        super.isAdvantage = true;
    }

    @Override
    public void takesAHit(int damage){
        int initialScore = getScore();
        setScore(initialScore - damage * scoreMultiplier);
    }

    @Override
    public void hits(int damage){
        int initialScore = getScore();
        setScore(initialScore + damage * scoreMultiplier);
    }


    @Override
    public String toString() {
        return "AdditionalGunShield{" +
                "isAdvantage=" + isAdvantage +
                    ", score=" + getScore() +
                    ", name='" + getName() + '\'' +
                    ", type= " + getType() + '\'' +
                "ability='" + ability + '\'' +
                ", scoreMultiplier=" + scoreMultiplier +
                '}';
    }
}
