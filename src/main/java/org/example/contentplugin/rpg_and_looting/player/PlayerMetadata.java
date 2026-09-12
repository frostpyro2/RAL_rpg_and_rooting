package org.example.contentplugin.rpg_and_looting.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.example.contentplugin.rpg_and_looting.stat.StatMap;
import org.example.contentplugin.rpg_and_looting.stat.provider.StatProvider;

public class PlayerMetadata implements StatProvider {
    private final OriginPlayerData origin;
    private final LivingEntity tmp;
    private final EquipSlot slot;
    public PlayerMetadata(OriginPlayerData origin){
        this(origin, Bukkit.getServer().getPlayer(origin.getUuid()));
    }

    public PlayerMetadata(OriginPlayerData origin, LivingEntity tmp){
        this.origin = origin;
        this.tmp = tmp;
        this.slot = EquipSlot.MAIN_HAND;
    }

    public PlayerMetadata(StatMap map, EquipSlot slot){
        origin = map.getData();
        tmp = map.tmp();
        this.slot = slot;
    }


    public OriginPlayerData getOrigin(){
        return origin;
    }

    @Override
    public EquipSlot getAction() {
        return EquipSlot.MAIN_HAND;
    }

    @Override
    public LivingEntity tmp() {
        return tmp;
    }

    @Override
    public double getStat(String stat) {
        return 0;
    }
}
