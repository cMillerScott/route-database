package com.arkanstone.routedatabase.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Area {

    private int id;
    private static int nextId;

    @NotBlank(message = "Name field must not be left blank")
    @Size(min=3, max=50, message = "Area name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "This description is too long...")
    private String description;

//    @NotBlank(message = "Area must be in a Region.")
    private Region region;

    public Area(String name, String description, Region region) {
        this();
        this.name = name;
        this.description = description;
        this.region = region;
    }

    public Area() {
        this.id = nextId;
        nextId++;
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Region getRegion() {
        return region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return id == area.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
