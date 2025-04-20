package com.example.lutemon.lutemon;

import android.os.Parcelable;

import com.example.lutemon.BattleArenaActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Lutemon implements Serializable{

    protected int id;
    protected String name; // name in here is used as the species name
    protected int level;
    protected int xp;
    protected int hp;
    protected int maxHp;
    protected String description;
    protected Attack lastAttack;
    protected boolean dead;
    protected List<Attack> attacks;

    protected int imageSource;

    protected boolean isSelected;

    public Lutemon(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.hp = hp;
        this.lastAttack = null;
        this.maxHp = maxHp;
        this.description = description;
        this.dead = false;
        this.attacks = new ArrayList<>();
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
    public Attack getLastAttack() {
        return lastAttack;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getImageSource() {
        return imageSource;
    }

    public String getStats() {
        return "Level: " + level + " XP: " + xp + " HP: " + maxHp;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public Attack getAttack(int index) {
        return attacks.get(index);
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
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

    public void setImageSource(int sourceId) {
        this.imageSource = sourceId;
    }


    public void setLastAttack(Attack lastAttack) {
        this.lastAttack = lastAttack;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    // performAttack

    public void performAttack(Lutemon target, Attack attack) {
        if (attack.isMissed(this)) {
            System.out.println(this.name + " missed " + target.name);
            if (Math.random() < 0.2) {
                System.out.println("Critical hit!");
                int damage = attack.calculateDamage(this);
                System.out.println(this.name + " did " + damage + " damage to itself!");
                this.setHp(this.getHp() - damage);
            } else {}// do nothing
        } else {
            int damage = attack.calculateDamage(this);
            System.out.println(this.name + " did " + damage + " damage!");
            target.setHp(target.getHp() - damage);
        }
        this.setLastAttack(attack);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void heal(int amount) {
        this.hp += amount;
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void levelUp() {
        this.level++;
        this.xp = 0;
        this.maxHp = this.maxHp + 10*this.level;
    }

    public void gainXp(int amount) {
        this.xp += amount;
        if (this.xp >= 100) {
            int exp = this.xp;
            this.levelUp();
            this.xp = exp - 100;
        }
    }


}
