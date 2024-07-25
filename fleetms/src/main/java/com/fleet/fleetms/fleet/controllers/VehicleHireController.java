package com.fleet.fleetms.fleet.controllers;

import com.fleet.fleetms.fleet.models.VehicleHire;
import com.fleet.fleetms.fleet.services.VehicleHireService;
import com.fleet.fleetms.fleet.services.VehicleService;
import com.fleet.fleetms.parameters.services.ClientService;
import com.fleet.fleetms.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleHireController {

    @Autowired private VehicleHireService vehicleHireService;
    @Autowired private ClientService clientService;
    @Autowired private LocationService locationService;
    @Autowired private VehicleService vehicleService;

    public Model addModelAttributes(Model model){
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("locations", locationService.getAll());
        model.addAttribute("vehicles", vehicleService.findAll());
        return model;
    }

    //Get All VehicleHires
    @GetMapping("/fleet/hires")
    public String findAll(Model model){
        model.addAttribute("hires", vehicleHireService.findAll());
        return "/fleet/hires";
    }

    @GetMapping("/fleet/hireAdd")
    public String addHire(Model model){
        addModelAttributes(model);
        return "/fleet/hireAdd";
    }

    @GetMapping("/fleet/hire/{op}/{id}")
    public String editHire(Model model, @PathVariable Integer id, @PathVariable String op){
        VehicleHire hire = vehicleHireService.findById(id);
        model.addAttribute("hire", hire);
        addModelAttributes(model);
        return "/fleet/hire"+op;
    }

    //Add VehicleHire
    @PostMapping("/fleet/hires")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/fleet/hires";
    }

    @RequestMapping(value="fleet/hire/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/fleet/hires";
    }

}
