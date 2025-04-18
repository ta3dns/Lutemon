package com.example.lutemon.lutemon.species;

import com.example.lutemon.lutemon.Attack;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.AirType;

public class Celestyne extends Lutemon implements AirType {

    public Celestyne(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }

    @Override
    public void aeroStrike(Lutemon target) {
        Attack aeroStrikeAttack = new Attack("Aero Strike", 50, 0.7, 0.2, 1.5);
        this.performAttack(target, aeroStrikeAttack);

    }

    @Override
    public void whirlwindDance(Lutemon target) {
        Attack whirlwindDanceAttack = new Attack("Whirlwind Dance", 20, 0.8, 0.1, 1.3);
        this.performAttack(target, whirlwindDanceAttack);

    }

    @Override
    public void tempestFury(Lutemon target) {
        Attack tempestFuryAttack = new Attack("Tempest Fury", 60, 0.7, 0.3, 1.6);
        this.performAttack(target, tempestFuryAttack);

    }

    @Override
    public void airBlast(Lutemon target) {
        Attack airBlastAttack = new Attack("Air Blast", 40, 0.8, 0.2, 1.1);
        this.performAttack(target, airBlastAttack);

    }
}
