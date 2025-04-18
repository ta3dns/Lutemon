package com.example.lutemon.lutemon.species;

import com.example.lutemon.lutemon.Attack;
import com.example.lutemon.lutemon.Lutemon;
import com.example.lutemon.lutemon.types.MagicType;

public class Dorikit extends Lutemon implements MagicType {
    public Dorikit(int id, String name, int level, int xp, int hp, int maxHp, String description) {
        super(id, name, level, xp, hp, maxHp, description);
    }

    @Override
    public void voidGrasp(Lutemon target) {
        Attack voidGraspAttack = new Attack("Void Grasp", 50, 0.7, 0.2, 1.5);
        this.performAttack(target, voidGraspAttack);
    }

    @Override
    public void mindProbe(Lutemon target) {
        Attack mindProbeAttack = new Attack("Mind Probe", 20, 0.8, 0.1, 1.3);
        this.performAttack(target, mindProbeAttack);
    }

    @Override
    public void realityFracture(Lutemon target) {
        Attack realityFractureAttack = new Attack("Reality Fracture", 60, 0.7, 0.3, 1.6);
        this.performAttack(target, realityFractureAttack);

    }

    @Override
    public void cognitiveCollapse(Lutemon target) {
        Attack cognitiveCollapseAttack = new Attack("Cognitive Collapse", 40, 0.8, 0.2, 1.7);
        this.performAttack(target, cognitiveCollapseAttack);

    }
}
