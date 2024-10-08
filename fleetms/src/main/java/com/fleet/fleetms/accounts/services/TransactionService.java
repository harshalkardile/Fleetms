package com.fleet.fleetms.accounts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.fleetms.accounts.models.Transaction;
import com.fleet.fleetms.accounts.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    //Get All Transactions
    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    //Get Transaction By Id
    public Transaction findById(int id) {
        return transactionRepository.findById(id).orElse(null);
    }

    //Delete Transaction
    public void delete(int id) {
        transactionRepository.deleteById(id);
    }

    //Update Transaction
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

}