package com.fleet.fleetms.parameters.controllers;

import com.fleet.fleetms.parameters.models.Country;
import com.fleet.fleetms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    @ResponseBody
    public List<Country> getAll(){
        return countryService.getAll();
    }
}
