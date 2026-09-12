package org.example.contentplugin.rpg_and_looting.trigger;

import java.util.HashMap;
import java.util.Map;

public class TriggerType {
    private final String toString;

    public TriggerType(String toString){
        this.toString = toString;
    }


    public static TriggerType LEFT_CLICK = new TriggerType("LEFT_CLICK"),
    RIGHT_CLICK = new TriggerType("RIGHT_CLICK"),
    SHIFT_LEFT = new TriggerType("SHIFT_LEFT"),
    SHIFT_RIGHT = new TriggerType("SHIFT_RIGHT"),
    SHIFT = new TriggerType("SHIFT"),
    DOUBLE_SHIFT = new TriggerType("DOUBLE_SHIFT"),
    ON_HIT = new TriggerType("ON_HIT"),
    ON_PLAYER_HIT = new TriggerType("ON_PLAYER_HIT"),
    ON_KILL = new TriggerType("ON_KILL"),
    ON_PLAYER_KILL = new TriggerType("ON_PLAYER_KILL"),
    ON_DEATH = new TriggerType("ON_DEATH");




    private static Map<String, TriggerType> triggers = new HashMap<>();

    static{
        put(LEFT_CLICK);
        put(RIGHT_CLICK);
        put(SHIFT_LEFT);
        put(SHIFT_RIGHT);

        put(SHIFT);
        put(DOUBLE_SHIFT);

        put(ON_HIT);
        put(ON_PLAYER_HIT);

        put(ON_KILL);
        put(ON_PLAYER_KILL);

        put(ON_DEATH);
    }

    private static void put(TriggerType type){
        triggers.put(type.toString, type);
    }


    public TriggerType getTriggerType(String key){
        return triggers.get(key);
    }


    public String toString(){
        return this.toString;
    }
}
