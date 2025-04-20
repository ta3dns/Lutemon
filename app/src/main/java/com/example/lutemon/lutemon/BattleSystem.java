package com.example.lutemon.lutemon;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutemon.BattleArenaActivity;

import java.util.List;
import java.util.Random;

public class BattleSystem {

    private final Lutemon player;
    private final Lutemon cpu;
    private Random random;
    public boolean isEnded;
    private static boolean isBattle;

    private TextView playerHpText;
    private TextView cpuHpText;
    private Context context;


    public BattleSystem(Context context, Lutemon player, Lutemon cpu, boolean isBattle, TextView playerHpText, TextView cpuHpText) {
        this.context = context;
        this.player = player;
        this.cpu = cpu;
        this.isEnded = true;
        this.random = new Random();
        BattleSystem.isBattle = isBattle;
        this.playerHpText = playerHpText;
        this.cpuHpText = cpuHpText;
    }

    public void setHpTXT() {
        playerHpText.setText("Player: " + player.getHp());
        cpuHpText.setText(cpu.getHp() + " :CPU");
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
        Toast.makeText(context, cpu.getName() + " attacks with " + cpu.getLastAttack().getName(), Toast.LENGTH_SHORT).show();
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
