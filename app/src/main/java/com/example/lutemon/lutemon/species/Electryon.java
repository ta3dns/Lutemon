package com.example.lutemon.lutemon.species;

import com.example.lutemon.lutemon.Attack;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.ElectricType;
import com.example.lutemon.lutemon.types.SteelType;

public class Electryon extends Lutemon implements ElectricType, SteelType {
    public Electryon(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }

    @Override
    public void ironBarrage() {
        Attack ironBarrageAttack = new Attack("Iron Barrage", 50, 0.7, 0.2, 1.5);
        attacks.add(ironBarrageAttack);
    }

    @Override
    public void steelFortress() {
        Attack steelFortressAttack = new Attack("Steel Fortress", 20, 0.8, 0.1, 1.3);
        attacks.add(steelFortressAttack);
    }

    @Override
    public void staticCharge() {
        Attack staticChargeAttack = new Attack("Static Charge", 60, 0.7, 0.3, 1.6);
        attacks.add(staticChargeAttack);
    }

    @Override
    public void lightningStorm() {
        Attack lightningStormAttack = new Attack("Lightning Storm", 40, 0.8, 0.2, 1.1);
        attacks.add(lightningStormAttack);
    }
}
