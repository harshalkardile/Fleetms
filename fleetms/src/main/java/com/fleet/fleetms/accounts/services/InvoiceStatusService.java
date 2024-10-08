package com.fleet.fleetms.accounts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.fleetms.accounts.models.InvoiceStatus;
import com.fleet.fleetms.accounts.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//Get All InvoiceStatuss
	public List<InvoiceStatus> findAll(){
		return invoiceStatusRepository.findAll();
	}	
	
	//Get InvoiceStatus By Id
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}	
	
	//Delete InvoiceStatus
	public void delete(int id) {
		invoiceStatusRepository.deleteById(id);
	}
	
	//Update InvoiceStatus
	public void save( InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

}
