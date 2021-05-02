package com.arkanstone.routedatabase.models;

public enum Region {

    NORTHCENTRAL("North Central"),
    NORTHWEST("North West"),
    NORTHEAST("North East"),
    RIVERVALLEYOUACHITAS("River Valley / Ouachitas");

    private final String displayName;

    Region(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
