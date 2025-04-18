package com.example.lutemon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BattleArenaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_battle_arena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btn_attack1).setOnClickListener(v -> performAttack(0));
        findViewById(R.id.btn_attack2).setOnClickListener(v -> performAttack(1));
        findViewById(R.id.btn_attack3).setOnClickListener(v -> performAttack(2));
        findViewById(R.id.btn_attack4).setOnClickListener(v -> performAttack(3));
        findViewById(R.id.btn_give_up).setOnClickListener(v -> giveUp());
    }
}