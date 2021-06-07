package com.arkanstone.routedatabase.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//  TODO: Add more fields to class(location/directions, pic, etc...)

@Entity
public class Area extends AbstractEntity {

    private Region region;

    @OneToMany(mappedBy = "area")
    private final List<Route> routes = new ArrayList<>();

    public Area(Region region) {
        this.region = region;
    }

    public Area() {
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
