package com.arkanstone.routedatabase.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

//   TODO: Add more fields to class (height, bolts, type, etc...)

@Entity
public class Route extends AbstractEntity {

    @ManyToOne
    @NotNull(message = "Route must be added within an Area")
    private Area area;

    public Route(Area area) {
        this.area = area;
    }

    public Route() {
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
