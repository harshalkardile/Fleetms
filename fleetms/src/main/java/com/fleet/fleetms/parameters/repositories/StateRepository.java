package com.fleet.fleetms.parameters.repositories;

import com.fleet.fleetms.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer > {
}
