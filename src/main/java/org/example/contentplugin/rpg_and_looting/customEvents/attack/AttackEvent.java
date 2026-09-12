package org.example.contentplugin.rpg_and_looting.customEvents.attack;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class AttackEvent extends EntityEvent implements Cancellable {
    private boolean cancel = false;
    private static HandlerList handlerList = new HandlerList();
    public AttackEvent(@NotNull Entity entity) {
        super(entity);
    }

    @Override
    public @NotNull Entity getEntity() {
        return super.getEntity();
    }

    @Override
    public @NotNull EntityType getEntityType() {
        return super.getEntityType();
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public boolean callEvent() {
        return super.callEvent();
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }

}
