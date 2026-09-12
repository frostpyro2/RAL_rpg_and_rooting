package org.example.contentplugin.rpg_and_looting.stat;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.example.contentplugin.rpg_and_looting.player.EquipSlot;
import org.example.contentplugin.rpg_and_looting.player.OriginPlayerData;
import org.example.contentplugin.rpg_and_looting.player.PlayerMetadata;
import org.example.contentplugin.rpg_and_looting.stat.instance.StatInstance;
import org.example.contentplugin.rpg_and_looting.stat.provider.PlayerStatProvider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatMap implements PlayerStatProvider {
    private final OriginPlayerData playerData;

    private final Map<String, StatInstance> stats = new ConcurrentHashMap<>();

    public StatMap(OriginPlayerData data){
        this.playerData = data;
    }
    @Override
    public double getStat(String stat) {
        return stats.get(stat).getFinal();
    }

    @Override
    public EquipSlot getAction() {
        return EquipSlot.MAIN_HAND;
    }

    @Override
    public Player getPlayer() {
        return PlayerStatProvider.super.getPlayer();
    }

    @Override
    public OriginPlayerData getData() {
        return playerData;
    }

    @Override
    public PlayerMetadata cache(EquipSlot slot) {
        return new PlayerMetadata(this, slot);
    }

    @Override
    public LivingEntity tmp() {
        return PlayerStatProvider.super.tmp();
    }
}
