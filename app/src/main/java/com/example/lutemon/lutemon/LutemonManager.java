package com.example.lutemon.lutemon;

import com.example.lutemon.lutemon.species.Celestyne;
import com.example.lutemon.lutemon.species.Dorikit;
import com.example.lutemon.lutemon.species.Electryon;
import com.example.lutemon.lutemon.species.Ignivulp;
import com.example.lutemon.lutemon.species.Tux;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LutemonManager {
    private List<Lutemon> playerLutemons;
    private static List<Lutemon> cpuLutemons;
    private int id = 100000;

    public LutemonManager() {
        playerLutemons = new ArrayList<>();
        cpuLutemons = new ArrayList<>();

    }

    public void addPlayerLutemon(Lutemon lutemon) {
        playerLutemons.add(lutemon);
    }

    public Lutemon createCpuLutemon(){
        id++;
        Random random = new Random();
        int level = random.nextInt(5) + 1;
        int species = random.nextInt(5) + 1;
        if (species == 1) {
            Lutemon cpuLutemon = new Ignivulp(id, "Ignivulp", level, 0, 100, 100, "CPU_FIGHTER");
            ((Ignivulp) cpuLutemon).makeAttacks();

            cpuLutemons.add(cpuLutemon);
            System.out.println("CPU = " + cpuLutemon.getName() + " " + cpuLutemon.getStats());
            return cpuLutemon;

        } else if (species == 2) {
            Lutemon cpuLutemon = new Tux(id, "Tux", level, 0, 100, 100, "CPU_FIGHTER");
            ((Tux) cpuLutemon).makeAttacks();

            cpuLutemons.add(cpuLutemon);
            System.out.println("CPU = " + cpuLutemon.getName() + " " + cpuLutemon.getStats());
            return cpuLutemon;

        } else if (species == 3) {
            Lutemon cpuLutemon = new Dorikit(id, "Dorikit", level, 0, 100, 100, "CPU_FIGHTER");
            ((Dorikit) cpuLutemon).makeAttacks();

            cpuLutemons.add(cpuLutemon);
            System.out.println("CPU = " + cpuLutemon.getName() + " " + cpuLutemon.getStats());
            return cpuLutemon;

        } else if (species == 4) {
            Lutemon cpuLutemon = new Celestyne(id, "Celestyne", level, 0, 100, 100, "CPU_FIGHTER");
            ((Celestyne) cpuLutemon).makeAttacks();

            cpuLutemons.add(cpuLutemon);
            System.out.println("CPU = " + cpuLutemon.getName() + " " + cpuLutemon.getStats());
            return cpuLutemon;

        } else {
            Lutemon cpuLutemon = new Electryon(id, "Electryon", level, 0, 100, 100, "CPU_FIGHTER");
            ((Electryon) cpuLutemon).makeAttacks();
            cpuLutemons.add(cpuLutemon);
            System.out.println("CPU = " + cpuLutemon.getName() + " " + cpuLutemon.getStats());
            return cpuLutemon;
        }
    }

    public List<Lutemon> getCpuLutemons() {
        return cpuLutemons;
    }

    public List<Lutemon> getPlayerLutemons() {
        return playerLutemons;
    }

    public static Lutemon getCpuLutemon() {
        int randomIndex = new Random().nextInt(cpuLutemons.size());
        return cpuLutemons.get(randomIndex);
    }
}
