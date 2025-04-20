package com.example.lutemon.lutemon.species;

import com.example.lutemon.lutemon.Attack;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.ElectricType;
import com.example.lutemon.lutemon.types.SteelType;

public class Electryon extends Lutemon implements ElectricType, SteelType {
    public Electryon(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }

    // overrites the electric and steel type methods
    @Override
    public void ironBarrage() {
        Attack ironBarrageAttack = new Attack("Iron Barrage", 5, 0.7, 0.2, 1.5);
        attacks.add(ironBarrageAttack);
    }

    @Override
    public void steelFortress() {
        Attack steelFortressAttack = new Attack("Steel Fortress", 2, 0.8, 0.1, 1.3);
        attacks.add(steelFortressAttack);
    }

    @Override
    public void staticCharge() {
        Attack staticChargeAttack = new Attack("Static Charge", 6, 0.7, 0.3, 1.6);
        attacks.add(staticChargeAttack);
    }

    @Override
    public void lightningStorm() {
        Attack lightningStormAttack = new Attack("Lightning Storm", 4, 0.8, 0.2, 1.1);
        attacks.add(lightningStormAttack);
    }

    public void makeAttacks() {
        ironBarrage();
        steelFortress();
        staticCharge();
        lightningStorm();
    }
}
