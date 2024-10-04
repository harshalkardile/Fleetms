package com.fleet.fleetms.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fleet.fleetms.parameters.services.ClientService;

@Controller
public class InvoiceController {
	@Autowired private InvoiceService invoiceService;
	@Autowired private InvoiceStatusService invoiceStatusService;
	@Autowired private ClientService clientService;
	

	@GetMapping("/accounts/invoices")
	public String  getAll(Model model){
		List<Invoice> invoices =   invoiceService.findAll();
		model.addAttribute("invoices", invoices);
		return "/accounts/invoices";
	}

	@GetMapping("/accounts/invoiceAdd")
	public String addInvoice(){
		return "accounts/invoiceAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/accounts/invoice/{op}/{id}")
	public String editInvoice(@PathVariable Integer id, @PathVariable String op, Model model){
		Invoice invoice = invoiceService.findById(id);
		model.addAttribute("invoice", invoice);
		return "/accounts/invoice"+ op;
	}

	@PostMapping("/accounts/invoices")
	public String save(Invoice invoice){
		invoiceService.save(invoice);
		return "redirect:/accounts/invoices";
	}

	@RequestMapping(value = "/accounts/invoices/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		invoiceService.delete(id);
		return "redirect:/accounts/invoices";
	}

}
