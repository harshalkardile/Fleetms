package com.fleet.fleetms.accounts.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fleet.fleetms.accounts.models.Transaction;
import com.fleet.fleetms.accounts.services.TransactionService;
import com.fleet.fleetms.accounts.services.TransactionStatusService;
import com.fleet.fleetms.accounts.services.TransactionTypeService;
import com.fleet.fleetms.hr.services.EmployeeService;
import com.fleet.fleetms.parameters.services.ClientService;
import com.fleet.fleetms.parameters.services.ContactService;
import com.fleet.fleetms.parameters.services.SupplierService;

public class TransactionController {
	
		@Autowired
	    private TransactionService transactionService;
	    @Autowired
	    private TransactionStatusService transactionStatusService;
	    @Autowired
	    private TransactionTypeService transactionTypeService;
	    @Autowired
	    private ContactService contactService;
	    @Autowired
	    private SupplierService supplierService;
	    @Autowired
	    private ClientService clientService;
	    @Autowired
	    private EmployeeService employeeService;

	    public Model addModelAttributes(Model model){
	        model.addAttribute("transactionStatuses", transactionStatusService.findAll());
	        model.addAttribute("transactionTypes", transactionTypeService.findAll());
	        model.addAttribute("contacts", contactService.findAll());
	        model.addAttribute("suppliers", supplierService.findAll());
	        model.addAttribute("clients", clientService.findAll());
	        model.addAttribute("employees", employeeService.findAll());
	        return model;
	    }

	    @GetMapping("/accounts/transactions")
	    public String  getAll(Model model){
	        List<Transaction> transactions =   transactionService.findAll();
	        model.addAttribute("transactions", transactions);
	        addModelAttributes(model);
	        return "/accounts/transactions";
	    }

	    @GetMapping("/accounts/transactionAdd")
	    public String addTransaction(Model model){
	        addModelAttributes(model);
	        return "accounts/transactionAdd";
	    }

	    //The op parameter is either Edit or Details
	    @GetMapping("/accounts/transaction/{op}/{id}")
	    public String editTransaction(@PathVariable Integer id, @PathVariable String op, Model model){
	        Transaction transaction = transactionService.findById(id);
	        model.addAttribute("transaction", transaction);
	        addModelAttributes(model);
	        return "/accounts/transaction"+ op;
	    }

	    @PostMapping("/accounts/transactions")
	    public String save(Transaction transaction){
	        transactionService.save(transaction);
	        return "redirect:/accounts/transactions";
	    }

	    @RequestMapping(value = "/accounts/transactions/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	    public  String delete(@PathVariable Integer id){
	        transactionService.delete(id);
	        return "redirect:/accounts/transactions";
	    }

}
