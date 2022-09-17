package com.playtika.java.academy.challenge1.badea.andreea.player;

import com.playtika.java.academy.challenge1.badea.andreea.exceptions.PlayerProfileException;
import com.playtika.java.academy.challenge1.badea.andreea.player.interfaces.Restorable;
import com.playtika.java.academy.challenge1.badea.andreea.powerups.interfaces.PowerUp;
import com.sun.jdi.ClassType;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerProfile implements Cloneable, Restorable {
    private String userName;
    private String email;
    private LocalDate creationDate;
    private int[] minutesPlayedPerSession;
    private List<PowerUp> powerUps = new ArrayList<>();

    private static int NB_OF_PROFILES;


    public PlayerProfile(String userName, String email) throws PlayerProfileException {
        this.userName = userName;
        this.setEmail(email);
        this.creationDate = LocalDate.now();
        NB_OF_PROFILES++;
    }


    public void setEmail(String email) throws PlayerProfileException {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            this.email = email;
        } else throw new PlayerProfileException("Email is not valid.");
    }


    public void setMinutesPlayedPerSession(int[] minutesPlayedPerSession) {
         this.minutesPlayedPerSession = Arrays.copyOf(minutesPlayedPerSession, minutesPlayedPerSession.length);
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public static int getNbOfProfiles() {
        return NB_OF_PROFILES;
    }

    public int getTotalPlayedTime() throws PlayerProfileException {
        int totalTime = 0;
        for (int minutesPlayed : minutesPlayedPerSession) {
            totalTime += minutesPlayed;
        }
        return totalTime;
    }

    public int getPlayerAgeInDays(){
        LocalDateTime localDateTime = LocalDateTime.now();
        int playerAge = (int) this.creationDate.until(localDateTime, ChronoUnit.DAYS);
        return playerAge;
    }

    public int getMaxPlayedMinutes(){
        int[] copyOfMaxPlayedMinutes = Arrays.copyOf(this.minutesPlayedPerSession, this.minutesPlayedPerSession.length);
        Arrays.sort(copyOfMaxPlayedMinutes);
        return copyOfMaxPlayedMinutes[copyOfMaxPlayedMinutes.length - 1];
    }

    public int[] getMinutesPlayedPerSession(){
        return Arrays.copyOf(minutesPlayedPerSession, minutesPlayedPerSession.length);
    }



    public void addNewPlaySession(){
        int[] copyPlayedTime = Arrays.copyOf(this.minutesPlayedPerSession, minutesPlayedPerSession.length + 1);
        this.minutesPlayedPerSession = Arrays.copyOf(copyPlayedTime, copyPlayedTime.length);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlayerProfile{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", creationDate=").append(creationDate);
        sb.append(", minutesPlayedPerSession=");
        if (minutesPlayedPerSession == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < minutesPlayedPerSession.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(minutesPlayedPerSession[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }


  @Override
    public Object clone() throws CloneNotSupportedException {
    PlayerProfile clonedPlayerProfile = (PlayerProfile) super.clone();
    clonedPlayerProfile.creationDate = creationDate;
    clonedPlayerProfile.minutesPlayedPerSession = Arrays.copyOf(minutesPlayedPerSession, minutesPlayedPerSession.length);
        return clonedPlayerProfile;
  }

    public void updateLastPlayedTime(int time) {
        this.minutesPlayedPerSession[this.minutesPlayedPerSession.length - 1] += time;
    }

    public void addPowerUp(PowerUp powerUp){
        powerUps.add(powerUp);
    }


    public void removePowerUp(String userName) {
        Iterator i = powerUps.iterator();
        String str = "";
        while (i.hasNext()) {
            str = (String) i.next();
            if (str.equals(userName)) {
                i.remove();
                break;
            }
        }
    }

    public PowerUp getPowerUps(String name) {
        PowerUp powerUp = null;
        for (PowerUp power : powerUps) {
            if (String.valueOf(power). equals(name)) {
                powerUp = getPowerUps(power.toString());
            }
        }
        return powerUp;
    }


    @Override
    public void saveProfile(String fileName) throws IOException {
        File logFile = new File("logs.txt");
        if(!logFile.exists()){
            logFile.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(logFile,true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(this.toString());
        printWriter.close();
    }


    @Override
    public void loadProfile(String fileName) throws IOException {
        File logFile = new File("logs.txt");
        FileReader fileReader = new FileReader(logFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = "";

        while((textLine = bufferedReader.readLine()) != null){
            System.out.println(textLine);
        }

        bufferedReader.close();
    }




}
