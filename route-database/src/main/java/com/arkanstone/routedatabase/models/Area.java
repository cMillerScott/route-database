package com.arkanstone.routedatabase.models;

import javax.persistence.Entity;

//  TODO: create relationship with Route(one to many?), add more fields to class(location/directions, pic, etc...)

@Entity
public class Area extends AbstractEntity {

    private Region region;

    public Area(Region region) {
        this.region = region;
    }

    public Area() {};

    public Region getRegion() { return region; }

    public void setRegion(Region region) { this.region = region; }

}
