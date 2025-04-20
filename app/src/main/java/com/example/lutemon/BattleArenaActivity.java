package com.example.lutemon;

import static android.os.SystemClock.sleep;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lutemon.lutemon.BattleSystem;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.LutemonManager;

import java.util.concurrent.atomic.AtomicInteger;

public class BattleArenaActivity extends AppCompatActivity {



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_arena);

        TextView playerHpText = findViewById(R.id.textView4);
        TextView cpuHpText = findViewById(R.id.textView5);
        // Check for the main layout view
        RelativeLayout mainLayout = findViewById(R.id.main);
        if (mainLayout == null) {
            // Log an error message
            android.util.Log.e("BattleArenaActivity", "RelativeLayout with ID 'main' not found in layout.");
            // Display an error to the user or finish the activity
            Toast.makeText(this, "Error: Could not load the battle arena.", Toast.LENGTH_LONG).show();
            finish();
            return; // Exit onCreate to prevent further errors
        }

        // Set up the background image
        ImageView ivArenaBackground = findViewById(R.id.iv_arena_background);
        String arenaTitle;
        if (MainActivity.battleIs) {
            arenaTitle = getString(R.string.battle_arena);
            ivArenaBackground.setImageResource(R.drawable.battle_area_background);
        } else {
            arenaTitle = getString(R.string.training_arena);
            ivArenaBackground.setImageResource(R.drawable.training_area_background);
        }

        // Set the arena title
        TextView arenaTitleTextView = findViewById(R.id.tv_arena_title);
        arenaTitleTextView.setText(arenaTitle);



        // Enable edge-to-edge feature
        EdgeToEdge.enable(this);

        // Set up window insets listener
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the selected Lutemon
        Lutemon selectedLutemon = (Lutemon) getIntent().getSerializableExtra("selectedLutemon");
        if (selectedLutemon != null) {
            TextView lutemonNameTextView = findViewById(R.id.lt_name); // maybe problem Here?
            lutemonNameTextView.setText(selectedLutemon.getName());
        } else {
            Toast.makeText(this, "No Lutemon selected!", Toast.LENGTH_SHORT).show();
            finish(); // Close the activity if no Lutemon is selected
        }

        // Set up attack button



        Button attackButton1 = findViewById(R.id.attack1);
        Button attackButton2 = findViewById(R.id.attack2);
        Button attackButton3 = findViewById(R.id.attack3);
        Button attackButton4 = findViewById(R.id.attack4);
        Button giveUpButton = findViewById(R.id.giveUp);

        attackButton1.setText(selectedLutemon.getAttacks().get(0).getName());
        attackButton2.setText(selectedLutemon.getAttacks().get(1).getName());
        attackButton3.setText(selectedLutemon.getAttacks().get(2).getName());
        attackButton4.setText(selectedLutemon.getAttacks().get(3).getName());


        if (MainActivity.battleIs) {
            Toast.makeText(this, "BATTLE IS STARTING", Toast.LENGTH_SHORT).show();
            System.out.println("BATTLE IS STARTING - Console");

            BattleSystem battleSystem = new BattleSystem(this, selectedLutemon, LutemonManager.getCpuLutemon(), MainActivity.battleIs, playerHpText, cpuHpText);

            attackButton1.setOnClickListener(v -> handleAttack(0, battleSystem, selectedLutemon));
            attackButton2.setOnClickListener(v -> handleAttack(1, battleSystem, selectedLutemon));
            attackButton3.setOnClickListener(v -> handleAttack(2, battleSystem, selectedLutemon));
            attackButton4.setOnClickListener(v -> handleAttack(3, battleSystem, selectedLutemon));
            giveUpButton.setOnClickListener(v -> giveUp(battleSystem, selectedLutemon));

        } else if (!MainActivity.battleIs) {
            Toast.makeText(this, "TRAINING IS STARTING", Toast.LENGTH_LONG).show();

            BattleSystem battleSystem = new BattleSystem(this, selectedLutemon, LutemonManager.getCpuLutemon(), MainActivity.battleIs, playerHpText, cpuHpText);

            attackButton1.setOnClickListener(v -> handleAttack(0, battleSystem, selectedLutemon));
            attackButton2.setOnClickListener(v -> handleAttack(1, battleSystem, selectedLutemon));
            attackButton3.setOnClickListener(v -> handleAttack(2, battleSystem, selectedLutemon));
            attackButton4.setOnClickListener(v -> handleAttack(3, battleSystem, selectedLutemon));
            giveUpButton.setOnClickListener(v -> giveUp(battleSystem, selectedLutemon));

        }
    }

    private void handleAttack(int attackIndex, BattleSystem battleSystem, Lutemon selectedLutemon) {

        battleSystem.setHpTXT();

            System.out.println("Handle Attack - Console");

            System.out.println("Attack Index: " + attackIndex);
            System.out.println(selectedLutemon.getAttacks());
            System.out.println(selectedLutemon.getName() + " attacks with " + selectedLutemon.getAttacks().get(attackIndex).getName());
        Toast.makeText(this, selectedLutemon.getName() + " attacks with " + selectedLutemon.getAttacks().get(attackIndex).getName(), Toast.LENGTH_SHORT).show();
        battleSystem.playerTurn(selectedLutemon.getAttacks().get(attackIndex));
        battleSystem.setHpTXT();

        System.out.println(battleSystem.getCpu().getName() + " Has " + battleSystem.getPlayer().getHp() + " HP Left!");
        if (battleSystem.getPlayer().getHp() <= 10) {
                System.out.println("CRITICALLY LOW HEALTH. ARE YOU SURE YOU WANT TO CONTINUE?");
            Toast.makeText(this, "CRITICALLY LOW HEALTH. ARE YOU SURE YOU WANT TO CONTINUE?", Toast.LENGTH_SHORT).show();
        }


        if (!battleSystem.getCpu().isAlive()) {
            System.out.println("CPU Is Alive False- Console");
            Toast.makeText(this, "YOU WON", Toast.LENGTH_LONG).show();
            battleSystem.isEnded = true;
            selectedLutemon.gainXp(25);
            Toast.makeText(this, "You Gained 25 XP", Toast.LENGTH_LONG).show();
            // refill health
            battleSystem.getPlayer().setHp(battleSystem.getPlayer().getMaxHp());
            battleSystem.getCpu().setHp(battleSystem.getCpu().getMaxHp());
            finish();
            return;
        }

        new Handler().postDelayed(() -> {
            System.out.println("CPU Turn - Console");

            battleSystem.setHpTXT();

            battleSystem.cpuTurn();

            battleSystem.setHpTXT();

            System.out.println(battleSystem.getPlayer().getName() + " Has " + battleSystem.getCpu().getHp() + " HP Left!");
            if (!battleSystem.getPlayer().isAlive()) {
                System.out.println("Player Is Alive False - Console");
                Toast.makeText(this, "YOU LOST", Toast.LENGTH_LONG).show();
                battleSystem.getCpu().gainXp(25);
                Toast.makeText(this, "Opponent Gained 25 XP", Toast.LENGTH_LONG).show();
                battleSystem.isEnded = true;
                MainActivity.lutemonList.remove(selectedLutemon);
                // Refill Health
                battleSystem.getCpu().setHp(battleSystem.getCpu().getMaxHp());
                finish();

            }
        }, 2000);
    }

        private void giveUp(BattleSystem battleSystem, Lutemon selectedLutemon){
            Toast.makeText(this, "YOU Gave Up", Toast.LENGTH_LONG).show();
            battleSystem.isEnded = true;
            // Refill health
            battleSystem.getPlayer().setHp(battleSystem.getPlayer().getMaxHp());
            battleSystem.getCpu().setHp(battleSystem.getCpu().getMaxHp());
            finish();
        }


}
