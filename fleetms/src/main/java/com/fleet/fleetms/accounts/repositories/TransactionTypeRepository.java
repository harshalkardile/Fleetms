package com.fleet.fleetms.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.fleetms.accounts.models.TransactionType;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
}
