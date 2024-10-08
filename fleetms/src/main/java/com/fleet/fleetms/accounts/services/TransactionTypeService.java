package com.fleet.fleetms.accounts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.fleetms.accounts.models.TransactionType;
import com.fleet.fleetms.accounts.repositories.TransactionTypeRepository;

@Service
public class TransactionTypeService {
	
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    //Get All TransactionTypes
    public List<TransactionType> findAll(){
        return transactionTypeRepository.findAll();
    }

    //Get TransactionType By Id
    public Optional<TransactionType> findById(int id) {
        return transactionTypeRepository.findById(id);
    }

    //Delete TransactionType
    public void delete(int id) {
        transactionTypeRepository.deleteById(id);
    }

    //Update TransactionType
    public void save( TransactionType transactionType) {
        transactionTypeRepository.save(transactionType);
    }

}
