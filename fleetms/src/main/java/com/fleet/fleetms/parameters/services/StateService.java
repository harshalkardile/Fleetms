package com.fleet.fleetms.parameters.services;


import com.fleet.fleetms.parameters.models.State;

import com.fleet.fleetms.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public List<State> getAll(){
        return stateRepository.findAll();
    }

    public void save(State state){
        stateRepository.save(state);
    }

    public void delete(Integer id){
        stateRepository.deleteById(id);
    }

    public State getById(Integer id) {
        return stateRepository.findById(id).orElse(null);
    }
}
