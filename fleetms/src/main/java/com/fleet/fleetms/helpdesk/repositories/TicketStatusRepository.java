package com.fleet.fleetms.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.fleetms.helpdesk.models.TicketStatus;

@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {

}