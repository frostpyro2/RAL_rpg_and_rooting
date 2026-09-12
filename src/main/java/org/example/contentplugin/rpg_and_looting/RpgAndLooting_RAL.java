package org.example.contentplugin.rpg_and_looting;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.contentplugin.rpg_and_looting.skillTrigger.SkillTrigger;
import org.example.contentplugin.rpg_and_looting.eventCaller.click.PlayerClickEventListener;
import org.example.contentplugin.rpg_and_looting.eventCaller.dataGen.DataGeneratorListener;

public final class RpgAndLooting_RAL extends JavaPlugin {
    private static RpgAndLooting_RAL plugin;
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        new DataGeneratorListener(this);
        new PlayerClickEventListener(this);
        new SkillTrigger(this);
    }

    public static Plugin getPlugin(){
        return plugin;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
