package org.example.contentplugin.rpg_and_looting.stat.provider;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.example.contentplugin.rpg_and_looting.player.EquipSlot;
import org.example.contentplugin.rpg_and_looting.player.OriginPlayerData;
import org.example.contentplugin.rpg_and_looting.player.PlayerMetadata;

public interface PlayerStatProvider extends StatProvider {
    default Player getPlayer(){
        return getData().getPlayer();
    }
    OriginPlayerData getData();
    PlayerMetadata cache(EquipSlot slot);
    @Override
    default LivingEntity tmp(){
        return getData().getPlayer();
    };
}
