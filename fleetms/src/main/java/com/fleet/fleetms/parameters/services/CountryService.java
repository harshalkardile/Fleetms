package com.fleet.fleetms.parameters.services;

import com.fleet.fleetms.parameters.models.Country;
import com.fleet.fleetms.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    public Page<Country> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return countryRepository.findAll(pageable);
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

    public Page<Country> findAllWithSort(String field, String direction, int pageNumber) {
        Sort sort = Sort.by(direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, field);
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
        return countryRepository.findAll(pageable);
    }

}

