package org.example.contentplugin.rpg_and_looting.damage.attack;

import org.bukkit.entity.LivingEntity;
import org.example.contentplugin.rpg_and_looting.damage.packet.DamageMetadata;
import org.example.contentplugin.rpg_and_looting.stat.provider.StatProvider;

import java.util.Objects;

public class AttackData {
    private final DamageMetadata data;
    private final LivingEntity target;
    private final StatProvider attacker;
    public AttackData(DamageMetadata data, LivingEntity target, StatProvider attacker){
        this.data = Objects.requireNonNull(data, "data can't be null!");
        this.target = target;
        this.attacker = attacker;
    }

    public DamageMetadata getData(){
        return data;
    }

    public LivingEntity getTarget(){
        return target;
    }

    public StatProvider getAttacker(){
        return attacker;
    }

    public boolean hasAttacker(){
        return attacker != null;
    }
}
