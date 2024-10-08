package com.fleet.fleetms.accounts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.fleetms.accounts.models.TransactionStatus;
import com.fleet.fleetms.accounts.repositories.TransactionStatusRepository;

@Service
public class TransactionStatusService {
    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    //Get All TransactionStatuss
    public List<TransactionStatus> findAll(){
        return transactionStatusRepository.findAll();
    }

    //Get TransactionStatus By Id
    public Optional<TransactionStatus> findById(int id) {
        return transactionStatusRepository.findById(id);
    }

    //Delete TransactionStatus
    public void delete(int id) {
        transactionStatusRepository.deleteById(id);
    }

    //Update TransactionStatus
    public void save( TransactionStatus transactionStatus) {
        transactionStatusRepository.save(transactionStatus);
    }

}
