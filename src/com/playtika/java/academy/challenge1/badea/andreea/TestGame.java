package com.playtika.java.academy.challenge1.badea.andreea;

import com.playtika.java.academy.challenge1.badea.andreea.exceptions.PlayerProfileException;
import com.playtika.java.academy.challenge1.badea.andreea.player.PlayerProfile;
import com.playtika.java.academy.challenge1.badea.andreea.powerups.AdditionalGunShield;
import com.playtika.java.academy.challenge1.badea.andreea.powerups.BonusShield;
import com.playtika.java.academy.challenge1.badea.andreea.powerups.BrokenShield;
import com.playtika.java.academy.challenge1.badea.andreea.powerups.enums.ShieldType;

import java.util.Random;
import java.util.function.IntSupplier;

public class TestGame {

    public static void main(String[] args) throws PlayerProfileException, CloneNotSupportedException {
        PlayerProfile profileOne = new PlayerProfile("user01", "user01@gmail.com");
        System.out.println("Number of profiles before creating profile two:  " + PlayerProfile.getNbOfProfiles());
        PlayerProfile profileTwo = new PlayerProfile("user02", "user02@gmail.com");
        System.out.println("Number of profiles after creating profile two: " + PlayerProfile.getNbOfProfiles());
        System.out.println("");

        System.out.println("First profile description: " + profileOne);
        System.out.println("Second profile description: " + profileTwo);
        System.out.println("");

        profileOne.setMinutesPlayedPerSession(new int[] {10, 20});
        profileOne.addNewPlaySession();
        profileOne.updateLastPlayedTime(4);
        System.out.println(profileOne);

        profileTwo.setMinutesPlayedPerSession(new int[] {2, 5, 1});
        profileTwo.addNewPlaySession();
        profileTwo.updateLastPlayedTime(30);
        profileTwo.addNewPlaySession();
        profileTwo.updateLastPlayedTime(50);
        System.out.println(profileTwo);
        System.out.println("");

        System.out.println("Number of profiles: " + PlayerProfile.getNbOfProfiles());

        PlayerProfile clonedProfile = (PlayerProfile) profileOne.clone();

        System.out.println("Cloned profile: " + clonedProfile);
        System.out.println("Number of profiles after creating a clone: " + PlayerProfile.getNbOfProfiles());
        System.out.println("");

        clonedProfile.setEmail("clonedUser@gmail.com");
        clonedProfile.addNewPlaySession();
        clonedProfile.updateLastPlayedTime(11);
        System.out.println("Cloned profile after update: " + clonedProfile);
        System.out.println("Unchanged profile one (deep copy was made): " + profileOne);
        System.out.println("");

        System.out.println("Maximum played time for cloned profile: " + clonedProfile.getMaxPlayedMinutes());
        System.out.println("Player age for cloned profile: " + clonedProfile.getPlayerAgeInDays());
        System.out.println("Total played time: " + clonedProfile.getTotalPlayedTime());
        System.out.println("");


        AdditionalGunShield additionalGunShield  = new AdditionalGunShield(2500, "addGunShield1", ShieldType.STRONG, "KILL", 10);
        System.out.println(additionalGunShield);

        additionalGunShield.hits(20);
        System.out.println("After hits: " + additionalGunShield);

        additionalGunShield.takesAHit(2);
        additionalGunShield.useAdditionalGun();
        System.out.println("After takesAHit: " + additionalGunShield);


        System.out.println("");
        BrokenShield brokenShield = new BrokenShield(2500, "brokenShield", ShieldType.STRONG, 5);
        System.out.println(brokenShield);

        brokenShield.takesAHit(2);
        System.out.println("After takesAHit: " + brokenShield);

        brokenShield.disable();
        brokenShield.takesAHit(2);
        System.out.println("After takesAHit: " + brokenShield);

        brokenShield.hits(5);
        System.out.println("After hits: " + brokenShield);


        Random random = new Random();
        int randInt = random.nextInt();
        BonusShield bonusShield = new BonusShield(2000, "bonusShield1", ShieldType.WEAK);
        IntSupplier supplier = () -> randInt;




    }
}
