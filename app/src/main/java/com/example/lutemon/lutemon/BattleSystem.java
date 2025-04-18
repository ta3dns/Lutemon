package com.example.lutemon.lutemon;
import java.util.List;
import java.util.Random;

public class BattleSystem {

    private final Lutemon player;
    private final Lutemon cpu;
    private Random random;
    private boolean isBattle;

    public BattleSystem(Lutemon player, Lutemon cpu) {
        this.player = player;
        this.cpu = cpu;
        this.isBattle = true;
        this.random = new Random();
    }

    public void playerTurn(Attack selectedAttack) {
        player.performAttack(cpu, selectedAttack);
        checkBattleOutcome();
    }

    public void cpuTurn(Attack selectedAttack) {
        cpu.performAttack(player, selectedAttack);
        checkBattleOutcome();
    }

    private Attack decideAttack(){
        List<Attack> cpuAttacks = cpu.getAttacks();

        int randIndex = random.nextInt(cpuAttacks.size());
        return cpuAttacks.get(randIndex);
    }

    private void checkBattleOutcome() {
        if (!player.isAlive()){
            System.out.println(cpu.getName() + " has won the battle!");
            if (isBattle){
                // Implement battle mechanics
                player.setDead(true);
            }
            isBattle = false;
        } else if (!cpu.isAlive()) {
            System.out.println(player.getName() + " has won the battle!");
            if (isBattle){
                // Implement battle mechanics
                cpu.setDead(true);
            }
            isBattle = false;
        } else {
            System.out.println("The battle continues...");
        }
    }

}
