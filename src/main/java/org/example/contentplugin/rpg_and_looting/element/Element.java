package org.example.contentplugin.rpg_and_looting.element;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Element {
    private final String name;
    private final static List<Element> register = new ArrayList<>();

    public Element(String name){
        this.name = name;
    }

    private static final Element none = new Element("none");

    public static void register(String name){
        register.add(new Element(name));
    }

    public boolean hasName(String name){
        return this.name.equals(name);
    }

    @Nullable
    public Element get(String name){
        for(Element target : register)
            if (target.hasName(name)) return target;
        return none;
    }
}
