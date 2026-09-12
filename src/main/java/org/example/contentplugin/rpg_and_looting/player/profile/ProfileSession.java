package org.example.contentplugin.rpg_and_looting.player.profile;

import org.example.contentplugin.rpg_and_looting.player.OriginPlayerData;
import org.example.contentplugin.rpg_and_looting.stat.StatMap;

import java.util.UUID;

public class ProfileSession {
    private final OriginPlayerData data;
    private final StatMap statMap;
    private final UUID uuid;

    private ProfileState state = ProfileState.OPEN;

    public ProfileSession(UUID uuid, OriginPlayerData parent){
        this.data = parent;
        this.uuid = uuid;
        statMap = new StatMap(parent);
    }

    public ProfileSession(OriginPlayerData data, ProfileSession reuse){
        this.data = data;
        statMap = reuse.getStatMap();
        this.uuid = data.getUuid();
    }

    public boolean hasProfile(){
        return uuid != null;
    }

    public OriginPlayerData getOriginPlayerData(){
        return data;
    }

    public UUID getUuid(){
        return uuid;
    }

    public StatMap getStatMap(){
        return statMap;
    }

    public boolean isDead(){
        return this.state.isDead();
    }

    public void setState(ProfileState state){
        this.state = state;
    }
}
