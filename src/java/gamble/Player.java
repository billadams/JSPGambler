/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamble;

import java.io.Serializable;

/**
 *
 * @author fssco
 */
public class Player implements Serializable{
    private String name;
    private double roll;
    private double lowest;
    private double highest;
    private final double STARTING;
    private int totalGuesses;
    private int totalCorrect;
    private int correctStreaks;
    private double initialMoney;
    private double highestMoney;
    private double lowestMoney;

    public Player(){
        this.name = "Kenny";
        this.roll = 1000;
        this.lowest = roll;
        this.highest = roll;
        this.STARTING = roll;
        this.totalGuesses = 0;
        this.totalCorrect = 0;
        this.initialMoney = 0.0;
        this.highestMoney = 0.0;
        this.lowestMoney = 0.0;
    }
    
    public Player(String name, double roll) {
        this.name = name;
        this.roll = roll;
        this.lowest = roll;
        this.highest = roll;
        this.STARTING = roll;
        this.totalGuesses = 0;
        this.totalCorrect = totalGuesses;
        this.correctStreaks = totalGuesses;
        this.initialMoney = roll;
        this.highestMoney = roll;
        this.lowestMoney = roll;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the roll
     */
    public double getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(double roll) {
        
        this.roll = roll;
        
    }

    
}
