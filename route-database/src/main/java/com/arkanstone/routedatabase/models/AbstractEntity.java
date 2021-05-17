package com.arkanstone.routedatabase.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name field must not be left blank")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 1000, message = "This description is too long...")
    private String description;

    public int getId() { return id; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
