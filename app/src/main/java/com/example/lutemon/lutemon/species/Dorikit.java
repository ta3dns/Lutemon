package com.example.lutemon.lutemon.species;

import android.os.Parcel;

import androidx.annotation.NonNull;

import com.example.lutemon.lutemon.Attack;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.MagicType;

import java.util.List;

public class Dorikit extends Lutemon implements MagicType {

    public Dorikit(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }

    // Overrites the magic type methods
    @Override
    public void voidGrasp() {
        Attack voidGraspAttack = new Attack("Void Grasp", 5, 0.7, 0.2, 1.5);
        attacks.add(voidGraspAttack);
    }

    @Override
    public void mindProbe() {
        Attack mindProbeAttack = new Attack("Mind Probe", 2, 0.8, 0.1, 1.3);
        attacks.add(mindProbeAttack);
    }

    @Override
    public void realityFracture() {
        Attack realityFractureAttack = new Attack("Reality Fracture", 6, 0.7, 0.3, 1.6);
        attacks.add(realityFractureAttack);
    }

    @Override
    public void cognitiveCollapse() {
        Attack cognitiveCollapseAttack = new Attack("Cognitive Collapse", 4, 0.8, 0.2, 1.7);
        attacks.add(cognitiveCollapseAttack);
    }

    public void makeAttacks() {
        voidGrasp();
        mindProbe();
        realityFracture();
        cognitiveCollapse();
    }


}
