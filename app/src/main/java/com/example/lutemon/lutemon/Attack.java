package com.example.lutemon.lutemon;

import java.io.Serializable;

public class Attack implements Serializable {
    private String name;
    private int baseDamage;
    private double accuracy;
    private double criticalChance;
    private double levelMultiplier;

    public Attack(String name, int baseDamage, double accuracy, double criticalChance, double levelMultiplier) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
        this.criticalChance = criticalChance;
        this.levelMultiplier = levelMultiplier;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public double getAccuracy() {
        return accuracy;
    }
    public double getCriticalChance() {
        return criticalChance;
    }
    public double getLevelMultiplier() {
        return levelMultiplier;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }
    public void setLevelMultiplier(double levelMultiplier) {
        this.levelMultiplier = levelMultiplier;
    }

    public int calculateDamage(Lutemon attacker) {


        double randomMultiplier = -0.15 + (Math.random() * 0.3);
        double levelDamage = attacker.getLevel()*levelMultiplier;
        double damage = (baseDamage + levelDamage) * (1 + randomMultiplier);

        if (Math.random() < criticalChance) {
            damage *= 1.5;
        }

        return (int)damage;
    }

    public boolean isMissed(Lutemon attacker){
        return Math.random() > accuracy;
    }
}
