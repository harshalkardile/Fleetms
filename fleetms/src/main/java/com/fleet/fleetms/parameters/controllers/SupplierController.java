package com.fleet.fleetms.parameters.controllers;

import com.fleet.fleetms.parameters.models.Supplier;
import com.fleet.fleetms.parameters.services.CountryService;
import com.fleet.fleetms.parameters.services.StateService;
import com.fleet.fleetms.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;

    public Model addModelAttributes(Model model){
        model.addAttribute("suppliers", supplierService.getAll());
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        return model;
    }

    @GetMapping("/parameters/suppliers")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/suppliers";
    }

    @GetMapping("/parameters/supplierAdd")
    public String addSupplier(Model model){
        model.addAttribute("countries", countryService.getAll());
        return "parameters/supplierAdd";
    }

    //The op parameter is either Edit or Details
    @GetMapping("/parameters/supplier/{op}/{id}")
    public String editSupplier(@PathVariable Integer id, @PathVariable String op, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        addModelAttributes(model);
        return "/parameters/supplier"+ op; //returns supplierEdit or supplierDetails
    }

    @PostMapping("/parameters/suppliers")
    public String save(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/parameters/suppliers";
    }

    @RequestMapping(value="/parameters/suppliers/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@PathVariable Integer id) {
        supplierService.deleteById(id);
        return "redirect:/parameters/suppliers";
    }

}
