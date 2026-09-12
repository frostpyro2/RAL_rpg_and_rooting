package org.example.contentplugin.rpg_and_looting.eventCaller.click;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import org.bukkit.plugin.Plugin;
import org.example.contentplugin.rpg_and_looting.RpgAndLooting_RAL;
import org.example.contentplugin.rpg_and_looting.customEvents.click.PlayerClickEvent;
import org.example.contentplugin.rpg_and_looting.player.OriginPlayerData;

public class PlayerClickEventListener implements Listener {
    public PlayerClickEventListener(Plugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.LOWEST)
    public void onRightClick(PlayerInteractEvent event){
        OriginPlayerData data = OriginPlayerData.get(event.getPlayer());
        switch (event.getAction()) {
            case RIGHT_CLICK_AIR, RIGHT_CLICK_BLOCK -> {
                if(data == null) break;
                data.setBlockClick(25);
                Bukkit.getPluginManager().callEvent(new PlayerClickEvent(event.getPlayer(), false, event.getClickedBlock(), event));
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDrop(PlayerDropItemEvent event){
        event.getPlayer().sendMessage("drop");
        OriginPlayerData data = OriginPlayerData.get(event.getPlayer());
        if(data != null){
            data.setBlockClick(30);
            data.setItemDrop(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onClose(InventoryCloseEvent event){

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLeftClick(PlayerAnimationEvent event){
        event.getPlayer().sendMessage("left");
        if(event.getAnimationType() != PlayerAnimationType.ARM_SWING) return;
        OriginPlayerData data = OriginPlayerData.get(event.getPlayer());
        if(data != null && !data.isLeftClickAbleBlock()) return;
        if(data != null && data.isItemDrop()){
            data.setItemDrop(false);
        }
        Bukkit.getScheduler().runTaskLater(RpgAndLooting_RAL.getPlugin(), ()->{
            Bukkit.getPluginManager().callEvent(new PlayerClickEvent(event.getPlayer(), true, null, event));
        }, 1L);
        if(data != null) data.setBlockClick(75);
    }
}
