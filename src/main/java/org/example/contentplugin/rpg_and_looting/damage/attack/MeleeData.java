package org.example.contentplugin.rpg_and_looting.damage.attack;

import org.bukkit.entity.LivingEntity;
import org.example.contentplugin.rpg_and_looting.damage.packet.DamageMetadata;
import org.example.contentplugin.rpg_and_looting.stat.provider.StatProvider;

public class MeleeData extends AttackData{

    public MeleeData(DamageMetadata data, LivingEntity target, StatProvider attacker) {
        super(data, target, attacker);
    }
}
