package com.fleet.fleetms.parameters.controllers;

import com.fleet.fleetms.parameters.models.State;
import com.fleet.fleetms.parameters.services.StateService;
import com.fleet.fleetms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    public  Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return model;
    }

    //Get All States
    @GetMapping("/parameters/states")
    public String findAll(Model model){
        addModelAttribute(model);
        return "/parameters/states";
    }

    @GetMapping("/parameters/stateAdd")
    public String addState(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @GetMapping("/parameters/state/{op}/{id}")
    public String editState(@PathVariable Integer id, @PathVariable String op, Model model){
        addModelAttribute(model);
        model.addAttribute("state", stateService.getById(id));
        return "/parameters/state" + op;
    }

    //Add State
    @PostMapping(value="/parameters/states")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/parameters/states";
    }

    @RequestMapping(value="/parameters/state/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }

}
