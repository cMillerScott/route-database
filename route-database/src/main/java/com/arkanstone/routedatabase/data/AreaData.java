package com.arkanstone.routedatabase.data;

import com.arkanstone.routedatabase.models.Area;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AreaData {
//    stores areas in key value pair
    private static final Map<Integer, Area> areas = new HashMap<>();
//    adds area to areas
    public static void add(Area area) {
        areas.put(area.getId(), area);
    }
//    get single area
    public static Area getById(int id) {
        return areas.get(id);
    }
//    get all areas
    public static Collection<Area> getAll() {
        return areas.values();
    }
//    remove single area
    public static void remove(int id) {
        areas.remove(id);
    }


}
