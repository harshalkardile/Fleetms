package com.fleet.fleetms.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.fleetms.accounts.models.TransactionStatus;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer> {
}