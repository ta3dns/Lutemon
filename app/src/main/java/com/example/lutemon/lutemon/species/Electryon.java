package com.example.lutemon.lutemon.species;

import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.ElectricType;
import com.example.lutemon.lutemon.types.SteelType;

public class Electryon extends Lutemon implements ElectricType, SteelType {
    public Electryon(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }
}
