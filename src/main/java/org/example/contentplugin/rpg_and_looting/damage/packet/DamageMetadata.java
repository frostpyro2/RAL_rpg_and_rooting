package org.example.contentplugin.rpg_and_looting.damage.packet;

import org.example.contentplugin.rpg_and_looting.element.Element;

import java.util.ArrayList;
import java.util.List;

public class DamageMetadata {
    private DamagePacket startPacket;
    private List<DamagePacket> packets = new ArrayList<>();

    public DamageMetadata(DamagePacket packet){
        startPacket = packet;
        packets.add(packet);
    }

    public DamageMetadata add(double value, List<DamageType> types){
        packets.add(new DamagePacket(value, types));
        return this;
    }

    public DamageMetadata add(double value, List<DamageType> types, Element element){
        packets.add(new DamagePacket(value, types, element));
        return this;
    }

    public DamageMetadata addModifier(double value){
        for(DamagePacket packet : packets)
            packet.setAdd(value);
        return this;
    }

    public DamageMetadata addModifier(double value, DamageType type){
        for(DamagePacket packet : packets) if(packet.hasType(type)) packet.setAdd(value);
        return this;
    }

}
