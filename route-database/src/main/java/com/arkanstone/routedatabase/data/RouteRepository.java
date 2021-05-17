package com.arkanstone.routedatabase.data;

import com.arkanstone.routedatabase.models.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {
}
