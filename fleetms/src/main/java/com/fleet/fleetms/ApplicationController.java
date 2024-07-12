package com.fleet.fleetms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String home(){
        return "index";
    }
    @GetMapping("/fleet")
    public String vehicle(){
        return "/fleet/index";
    }
    @GetMapping("/helpdesk")
    public String helpdesk(){
        return "/helpdesk/index";
    }
    @GetMapping("/accounts")
    public String account(){
        return "/accounts/index";
    }
    @GetMapping("/hr")
    public String layout(){
        return "/hr/index";
    }
    @GetMapping("/parameters")
    public String setting(){
        return "/parameters/index";
    }
    @GetMapping("/payroll")
    public String payroll(){
        return "/payroll/index";
    }

}
