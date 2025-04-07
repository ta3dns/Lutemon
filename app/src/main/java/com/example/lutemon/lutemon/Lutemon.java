package com.example.lutemon.lutemon;

public abstract class Lutemon {

    protected int id;
    protected String name;
    protected int level;
    protected int xp;
    protected int hp;
    protected int maxHp;
    protected String description;

    public Lutemon(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.hp = hp;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getXp() {
        return xp;
    }
    public int getHp() {
        return hp;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public String getDescription() {
        return description;
    }
    public int getId(){
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
