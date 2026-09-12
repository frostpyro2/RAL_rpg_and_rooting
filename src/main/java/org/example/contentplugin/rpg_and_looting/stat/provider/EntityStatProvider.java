package org.example.contentplugin.rpg_and_looting.stat.provider;

import org.bukkit.entity.LivingEntity;
import org.example.contentplugin.rpg_and_looting.player.EquipSlot;

public class EntityStatProvider implements StatProvider{
    private final LivingEntity entity;
    public EntityStatProvider(LivingEntity entity){
        this.entity = entity;
    }
    @Override
    public double getStat(String stat) {
        return 0;
    }

    @Override
    public LivingEntity tmp() {
        return entity;
    }

    @Override
    public EquipSlot getAction() {
        return EquipSlot.MAIN_HAND;
    }
}
