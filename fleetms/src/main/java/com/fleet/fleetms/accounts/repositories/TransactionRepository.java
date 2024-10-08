package com.fleet.fleetms.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.fleetms.accounts.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
