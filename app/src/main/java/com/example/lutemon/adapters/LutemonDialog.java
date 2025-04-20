package com.example.lutemon.adapters;

// LutemonDialog.java
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.lutemon.MainActivity;
import com.example.lutemon.R;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.LutemonManager;
import com.example.lutemon.lutemon.species.Celestyne;
import com.example.lutemon.lutemon.species.Dorikit;
import com.example.lutemon.lutemon.species.Electryon;
import com.example.lutemon.lutemon.species.Ignivulp;
import com.example.lutemon.lutemon.species.Tux;

public class LutemonDialog extends Dialog {
    private LutemonManager lutemonManager;

    public LutemonDialog(@NonNull Context context, LutemonManager manager) {
        super(context);
        this.lutemonManager = manager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_lutemon);

        Spinner lutemonTypeSpinner = findViewById(R.id.lutemonTypeSpinner);
        EditText lutemonName = findViewById(R.id.lutemonName);

        Button createLutemonButton = findViewById(R.id.createLutemonButton);

        String[] lutemonTypes = {"Ignivulp", "Tux", "Dorikit", "Celestyne", "Electryon"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, lutemonTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lutemonTypeSpinner.setAdapter(adapter);

        createLutemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = lutemonName.getText().toString();
                int level;
                int health;
                int id=0;
                String type = lutemonTypeSpinner.getSelectedItem().toString();

                try {
                    level = 1;
                    health = 100;

                    if (type.equals("Ignivulp")) {
                        id++;
                        Lutemon newLutemon = new Ignivulp(id, name, level, 0, health, health, "Player Created Lutemon");
                        ((Ignivulp) newLutemon).makeAttacks();
                        newLutemon.setImageSource(R.drawable.ignivulp_front);
                        lutemonManager.addPlayerLutemon(newLutemon);
                        MainActivity.lutemonList.add(newLutemon);
                    } else if (type.equals("Tux")){
                        id++;
                        Lutemon newLutemon = new Tux(id, name, level, 0, health, health, "Player Created Lutemon");
                        ((Tux) newLutemon).makeAttacks();
                        newLutemon.setImageSource(R.drawable.tux_front);
                        lutemonManager.addPlayerLutemon(newLutemon);
                        MainActivity.lutemonList.add(newLutemon);
                    } else if (type.equals("Dorikit")){
                        id++;
                        Lutemon newLutemon = new Dorikit(id, name, level, 0, health, health, "Player Created Lutemon");
                        ((Dorikit) newLutemon).makeAttacks();
                        newLutemon.setImageSource(R.drawable.dorikit_front);
                        lutemonManager.addPlayerLutemon(newLutemon);
                        MainActivity.lutemonList.add(newLutemon);

                    } else if (type.equals("Celestyne")){
                        id++;
                        Lutemon newLutemon = new Celestyne(id, name, level, 0, health, health, "Player Created Lutemon");
                        ((Celestyne) newLutemon).makeAttacks();
                        newLutemon.setImageSource(R.drawable.celestyne_front);
                        lutemonManager.addPlayerLutemon(newLutemon);
                        MainActivity.lutemonList.add(newLutemon);
                    } else {
                        id++;
                        Lutemon newLutemon = new Electryon(id, name, level, 0, health, health, "Player Created Lutemon");
                        ((Electryon) newLutemon).makeAttacks();
                        newLutemon.setImageSource(R.drawable.electryon_front);
                        lutemonManager.addPlayerLutemon(newLutemon);
                        MainActivity.lutemonList.add(newLutemon);
                    }

                    lutemonManager.createCpuLutemon();
                    Toast.makeText(getContext(), "Player Lutemon created!", Toast.LENGTH_SHORT).show();

                    dismiss(); // Close the dialog
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "Please enter valid values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
