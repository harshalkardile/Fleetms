package com.fleet.fleetms.fleet.controllers;

import com.fleet.fleetms.fleet.models.VehicleMovement;
import com.fleet.fleetms.fleet.services.VehicleMovementService;
import com.fleet.fleetms.fleet.services.VehicleService;
import com.fleet.fleetms.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleMovementController {

    @Autowired private VehicleMovementService vehicleMovementService;
    @Autowired private LocationService locationService;
    @Autowired private VehicleService vehicleService;

    public Model addModelAttributes(Model model){
        model.addAttribute("locations1", locationService.getAll());
        model.addAttribute("locations2", locationService.getAll());
        model.addAttribute("vehicles", vehicleService.findAll());
        return  model;
    }
    //Get All VehicleMovements
    @GetMapping("fleet/movements")
    public String findAll(Model model){
        model.addAttribute("movements", vehicleMovementService.findAll());
        return "fleet/movements";
    }

    @GetMapping("/fleet/movementAdd")
    public String addMovement(Model model){
        addModelAttributes(model);
        return "/fleet/movementAdd";
    }

    @GetMapping("/fleet/movement/{op}/{id}")
    public String editMovement(Model model, @PathVariable Integer id, @PathVariable String op){
        VehicleMovement movement = vehicleMovementService.findById(id);
        model.addAttribute("movement", movement);
        addModelAttributes(model);
        return "/fleet/movement"+op;
    }

    //Add VehicleMovement
    @PostMapping("/fleet/movements")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/fleet/movements";
    }

    @RequestMapping(value="/fleet/movements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/fleet/movements";
    }


}
