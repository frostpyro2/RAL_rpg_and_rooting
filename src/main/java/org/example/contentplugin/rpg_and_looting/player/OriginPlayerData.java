package org.example.contentplugin.rpg_and_looting.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.example.contentplugin.rpg_and_looting.player.profile.ProfileSession;
import org.example.contentplugin.rpg_and_looting.stat.StatMap;
import org.example.contentplugin.rpg_and_looting.trigger.TriggerType;

import java.util.*;

public class OriginPlayerData {
    private final UUID uuid;
    private long leftClick;
    private long itemDrop;
    private final Player player;
    private boolean isItemDrop = false;

    public OriginPlayerData(UUID uuid){
        this(uuid, Bukkit.getServer().getPlayer(uuid));
    }

    public OriginPlayerData(UUID uuid, Player player){
        this.player = player;
        this.uuid = uuid;
    }


    private final static Map<UUID, OriginPlayerData> caches = new WeakHashMap<>();


    public UUID getUuid(){
        return uuid;
    }

    public void setBlockClick(long milliSec){
        leftClick = System.currentTimeMillis() + milliSec;
    }

    public boolean isLeftClickAbleBlock(){
        return leftClick < System.currentTimeMillis();
    }

    public boolean isItemDrop(){
        return isItemDrop;
    }

    public void setItemDrop(boolean isItemDrop){
        this.isItemDrop = isItemDrop;
    }

    public StatMap getStatMap(){
        return getSafe().getStatMap();
    }

    public Player getPlayer(){
        return player;
    }

    private final Map<UUID, ProfileSession> sessions = new HashMap<>();

    private ProfileSession profileSession;
    private final Object sessionLock = new Object();


    public void chooseProfile(UUID uuid){
        synchronized (sessionLock){
            ProfileSession session;
            if(this.profileSession != null){
                //if this session exists

            }
            else if((session = sessions.remove(uuid)) != null){
                //else if this session should be restored
                this.profileSession = new ProfileSession(this, session);
            }
            else{
                //else this session DNE
                session = new ProfileSession(this.uuid, this);
                profileSession = session;
            }
        }
    }

    public void saveProfile(){
        synchronized (sessionLock){
            if(profileSession == null) return;

            UUID mapKey =this.profileSession.hasProfile() ? this.profileSession.getUuid() : null;
            this.sessions.put(mapKey, this.profileSession);
            this.profileSession = null;
        }
    }

    private ProfileSession getSafe(){
        ProfileSession session;
        synchronized (sessionLock){
            session = profileSession;
        }
        return session;
    }



    public void cast(TriggerType type){

    }
    public static void register(OriginPlayerData data){
        caches.put(data.getUuid(), data);
        Bukkit.getServer().getConsoleSender().sendMessage("added" + Bukkit.getServer().getPlayer(data.getUuid()).getName() + data.getUuid().toString());
    }

    public static void drop(OriginPlayerData data){
        caches.remove(data.getUuid());
    }

    public static OriginPlayerData get(Player player){
        return get(player.getUniqueId());
    }

    public static OriginPlayerData get(UUID uuid){
        return caches.get(uuid);
    }
}
