package com.arkanstone.routedatabase.data;

import com.arkanstone.routedatabase.models.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
}
