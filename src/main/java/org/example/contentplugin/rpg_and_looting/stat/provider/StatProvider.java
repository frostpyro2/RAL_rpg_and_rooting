package org.example.contentplugin.rpg_and_looting.stat.provider;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.example.contentplugin.rpg_and_looting.player.EquipSlot;
import org.example.contentplugin.rpg_and_looting.player.OriginPlayerData;
import org.example.contentplugin.rpg_and_looting.stat.StatMap;

public interface StatProvider {
    double getStat(String stat);
    LivingEntity tmp();
    EquipSlot getAction();
    static StatProvider get(LivingEntity entity, EquipSlot slot, boolean snapShot){
        if(!(entity instanceof Player player)) return new EntityStatProvider(entity);

        StatMap statMap = OriginPlayerData.get(player).getStatMap();
        return snapShot ? statMap.cache(slot) : statMap;
    }
}
