package org.example.contentplugin.rpg_and_looting.player.profile;

public enum ProfileState {
    OPENING,
    OPEN,
    CLOSING,
    CLOSED,
    DEAD,
    DEAD_EARLY,
    ABORTING;

    public boolean wasReady(){
        return this == OPEN || this == CLOSING || this == DEAD;
    }

    public boolean isClosing(){
        return this == CLOSING || this == ABORTING;
    }

    public boolean isWaiting() {
        return this == CLOSING || this == ABORTING || this == OPENING;
    }

    public boolean isDead() {
        return this == DEAD || this == DEAD_EARLY;
    }
}
