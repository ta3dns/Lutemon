package com.example.lutemon.lutemon;
import java.util.List;
import java.util.Random;

public class BattleSystem {

    private final Lutemon player;
    private final Lutemon cpu;
    private Random random;
    public boolean isEnded;
    private static boolean isBattle;


    public BattleSystem(Lutemon player, Lutemon cpu, boolean isBattle) {
        this.player = player;
        this.cpu = cpu;
        this.isEnded = true;
        this.random = new Random();
        BattleSystem.isBattle = isBattle;
    }

    public static boolean isBattle() {
        return isBattle;
    }

    public Lutemon getPlayer() {
        return player;
    }

    public Lutemon getCpu() {
        return cpu;
    }

    public void playerTurn(Attack selectedAttack) {
        player.performAttack(cpu, selectedAttack);

        checkBattleOutcome();
    }

    public void cpuTurn() {
        cpu.performAttack(player, decideAttack());
        System.out.println(cpu.getName() + " attacks with " + cpu.getLastAttack().getName());
        checkBattleOutcome();
    }

    private Attack decideAttack(){
        System.out.println(cpu.getAttacks().size());
        System.out.println(cpu.getAttacks());
        System.out.println("Deciding Attack");
        int randIndex = random.nextInt(cpu.getAttacks().size());
        return cpu.getAttack(randIndex);

    }

    private void checkBattleOutcome() {
        if (!player.isAlive()){
            System.out.println(cpu.getName() + " has won the battle!");
            if (isEnded){
                // Implement battle mechanics
                player.setDead(true);
            }
            isEnded = false;
        } else if (!cpu.isAlive()) {
            System.out.println(player.getName() + " has won the battle!");
            if (isEnded){
                // Implement battle mechanics
                cpu.setDead(true);
            }
            isEnded = false;
        } else {
            System.out.println("The battle continues...");
        }
    }

}
