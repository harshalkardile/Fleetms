package com.fleet.fleetms.parameters.repositories;

import com.fleet.fleetms.parameters.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
