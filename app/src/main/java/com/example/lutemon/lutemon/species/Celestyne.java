package com.example.lutemon.lutemon.species;

import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.AirType;

public class Celestyne extends Lutemon implements AirType {

    public Celestyne(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }
}
