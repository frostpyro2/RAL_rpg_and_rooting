package org.example.contentplugin.rpg_and_looting.skillTrigger;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.example.contentplugin.rpg_and_looting.customEvents.click.PlayerClickEvent;
import org.example.contentplugin.rpg_and_looting.player.EquipSlot;
import org.example.contentplugin.rpg_and_looting.player.PlayerMetadata;
import org.example.contentplugin.rpg_and_looting.stat.provider.StatProvider;
import org.example.contentplugin.rpg_and_looting.trigger.TriggerType;

import java.util.HashMap;
import java.util.Map;

public class SkillTrigger implements Listener {
    private final Map<PlayerMetadata, Long> shiftCoolDown = new HashMap<>();
    public SkillTrigger(Plugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void clickEvent(PlayerClickEvent event){
        if(event.getPlayerData().isItemDrop()){
            event.getPlayerData().setItemDrop(false);
            return;
        }
        TriggerType type = event.getLeft() ? event.getPlayer().isSneaking() ? TriggerType.SHIFT_LEFT : TriggerType.LEFT_CLICK : event.getPlayer().isSneaking() ? TriggerType.SHIFT_RIGHT : TriggerType.RIGHT_CLICK;
        event.getPlayerData().cast(type);
    }

    @EventHandler
    public void sneakEvent(PlayerToggleSneakEvent event){
        PlayerMetadata data = (PlayerMetadata) StatProvider.get(event.getPlayer(), EquipSlot.MAIN_HAND, true);

    }
}
