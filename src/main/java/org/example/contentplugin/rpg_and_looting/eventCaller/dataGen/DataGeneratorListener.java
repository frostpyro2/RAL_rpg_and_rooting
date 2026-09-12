package org.example.contentplugin.rpg_and_looting.eventCaller.dataGen;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.plugin.Plugin;
import org.example.contentplugin.rpg_and_looting.player.OriginPlayerData;

public class DataGeneratorListener implements Listener {
    public DataGeneratorListener(Plugin plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        OriginPlayerData data = new OriginPlayerData(player.getUniqueId());
        OriginPlayerData.register(data);
    }

    @EventHandler
    public void onReload(ServerLoadEvent event){
        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            if(OriginPlayerData.get(player) != null) break;
            OriginPlayerData.register(new OriginPlayerData(player.getUniqueId()));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        OriginPlayerData.drop(OriginPlayerData.get(event.getPlayer()));
    }
}
