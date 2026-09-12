package org.example.contentplugin.rpg_and_looting.customEvents.click;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.example.contentplugin.rpg_and_looting.player.OriginPlayerData;
import org.jetbrains.annotations.NotNull;

public class PlayerClickEvent extends PlayerEvent implements Cancellable {
    private final static HandlerList handler = new HandlerList();
    private final OriginPlayerData data;
    private final Player originPlayer;
    private boolean isLeft;
    private boolean cancel = false;
    private Cancellable cancellable;
    private Block block;
    public PlayerClickEvent(Player player, boolean isLeft, Block block, Cancellable cancellable){
        super(player);
        originPlayer = player;
        data = OriginPlayerData.get(player);
        this.isLeft = isLeft;
        this.cancellable = cancellable;
        this.block = block;
    }


    public OriginPlayerData getPlayerData(){
        return data;
    }

    public Block getBlock(){
        return block;
    }

    public Cancellable getOriginEvent(){
        return cancellable;
    }

    public boolean getLeft(){
        return isLeft;
    }

    public Player getOriginPlayer() {
        return originPlayer;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Deprecated
    @Override
    public @NotNull HandlerList getHandlers() {
        return handler;
    }



    public static HandlerList getHandlerList(){
        return handler;
    }
}
