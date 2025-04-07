package com.example.lutemon.lutemon.species;

import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.IceType;
import com.example.lutemon.lutemon.types.WaterType;

public class Tux extends Lutemon implements WaterType, IceType {
    public Tux(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }
}
