package com.fleet.fleetms.parameters.services;

import com.fleet.fleetms.parameters.models.Country;
import com.fleet.fleetms.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    public void save(Country country){
        countryRepository.save(country);
    }

    public void delete(Integer id){
        countryRepository.deleteById(id);
    }

    public Country getById(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }

    public List<Country> findByKeyword(String keyword){
        return countryRepository.findByKeyword(keyword);
    }
}
