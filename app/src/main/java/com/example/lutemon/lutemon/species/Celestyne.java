package com.example.lutemon.lutemon.species;

import android.os.Parcel;

import androidx.annotation.NonNull;

import com.example.lutemon.lutemon.Attack;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.AirType;

import java.util.List;

public class Celestyne extends Lutemon implements AirType {

    public Celestyne(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }

    // Overrites the air type methods
    @Override
    public void aeroStrike() {
        Attack aeroStrikeAttack = new Attack("Aero Strike", 5, 0.7, 0.2, 1.5);
        attacks.add(aeroStrikeAttack);

    }

    @Override
    public void whirlwindDance() {
        Attack whirlwindDanceAttack = new Attack("Whirlwind Dance", 2, 0.8, 0.1, 1.3);
        attacks.add(whirlwindDanceAttack);
    }

    @Override
    public void tempestFury() {
        Attack tempestFuryAttack = new Attack("Tempest Fury", 6, 0.7, 0.3, 1.6);
        attacks.add(tempestFuryAttack);
    }

    @Override
    public void airBlast() {
        Attack airBlastAttack = new Attack("Air Blast", 4, 0.8, 0.2, 1.1);
        attacks.add(airBlastAttack);
    }

    public void makeAttacks() {
        aeroStrike();
        whirlwindDance();
        tempestFury();
        airBlast();
    }

}
