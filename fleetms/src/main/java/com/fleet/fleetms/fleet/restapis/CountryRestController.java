package com.fleet.fleetms.fleet.restapis;

import com.fleet.fleetms.parameters.models.Country;
import com.fleet.fleetms.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/api/countries")
    public List<Country> getAll(Model model) {
        List<Country> countries = countryService.getAll();
        return countries;
    }
}
