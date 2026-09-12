package org.example.contentplugin.rpg_and_looting.damage.packet;

import org.example.contentplugin.rpg_and_looting.element.Element;

import java.util.ArrayList;
import java.util.List;

public class DamagePacket implements Cloneable{
    private double value, multiply, add = 1;
    private List<DamageType> types = new ArrayList<>();
    private Element element;

    public DamagePacket(double value, List<DamageType> types){
        this(value, types, null);
    }

    public DamagePacket(double value, List<DamageType> types, Element element){
        this.value = value;
        this.types = types;
        this.element = element;
    }

    public void setMultiplier(double multiply){
        this.multiply *= multiply;
    }

    public void setAdd(double add){
        this.add += add;
    }

    public double getFinal(){
        return value * Math.max(0, 1 + multiply) + add;
    }

    public boolean hasType(DamageType type){
        return types.contains(type);
    }

    public DamagePacket clone() throws CloneNotSupportedException{
        DamagePacket clone = new DamagePacket(value, types);
        clone.multiply = multiply;
        clone.add = add;
        clone.element = element;
        return clone;
    }
}
