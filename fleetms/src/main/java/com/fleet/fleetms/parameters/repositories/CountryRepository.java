package com.fleet.fleetms.parameters.repositories;

import com.fleet.fleetms.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

     @Query(value = "select c from Country c where " +
             "c.description like %?1% or c.capital like %?1%")
     List<Country> findByKeyword(String keyword);

}
