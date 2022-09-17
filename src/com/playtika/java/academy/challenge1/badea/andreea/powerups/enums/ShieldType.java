package com.playtika.java.academy.challenge1.badea.andreea.powerups.enums;

public enum ShieldType {
    STRONG("Heals"),
    WEAK("Shots"),
    INVINCIBLE("Invisible");

    private String specialAbility;


    ShieldType(String specialAbility) {
        this.specialAbility = specialAbility;

    }

    public String getSpecialAbility(){
        return this.specialAbility;
    }




}
