package com.fleet.fleetms.parameters.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fleet.fleetms.parameters.models.Country;
import com.fleet.fleetms.parameters.services.CountryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model, String keyword){
        List<Country> countries;
        System.out.println(keyword);
        countries = keyword == null? countryService.getAll():countryService.findByKeyword(keyword);
        model.addAttribute("countries", countries);
        return "parameters/countryList";
    }

    @GetMapping("/countries/{field}")
    public String getAllWithSort(Model model, @PathVariable("field") String field, @RequestParam(value = "sortDir", required = false) String sortDir) {
        if (sortDir == null || sortDir.isEmpty()) {
            sortDir = "asc";  // Default to ascending order if no direction is provided
        }
        List<Country> countries = countryService.findAllWithSort(field, sortDir);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("countries", countries);
        return "parameters/countryList";
    }
    //The Get Country By Id
    @GetMapping("/parameters/country/{id}")
    @ResponseBody
    public Country getCountry(@PathVariable Integer id){
        return countryService.getById(id);
    }
    @GetMapping("/countryAdd")
    public String addCountry() {
        return "parameters/countryAdd";
    }

    @GetMapping("/countryEdit/{id}")
    public String editCountry(@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryEdit";
    }

    @GetMapping("/countryDetails/{id}")
    public String detailsCountry(@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryDetails";
    }

    @PostMapping("/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }


}