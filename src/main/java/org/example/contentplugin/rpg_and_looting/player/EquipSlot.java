package org.example.contentplugin.rpg_and_looting.player;

import org.bukkit.inventory.EquipmentSlot;

public enum EquipSlot {
    HEAD(true, false, EquipmentSlot.HEAD),
    BODY(true, false, EquipmentSlot.BODY),
    MAIN_HAND(false, true, EquipmentSlot.HAND),
    OFF_HAND(false, true, EquipmentSlot.OFF_HAND),
    INVENTORY(false, true, EquipmentSlot.CHEST)
    ;
    private boolean body;
    private boolean hand;
    private EquipmentSlot slot;
    EquipSlot(boolean body, boolean hand, EquipmentSlot slot){
        this.body = body;
        this.hand = hand;
        this.slot = slot;
    }

    public EquipmentSlot bukkitSlot(){
        return slot;
    }

    public boolean isBody(){
        return body;
    }

    public boolean isHand(){
        return hand;
    }
}
