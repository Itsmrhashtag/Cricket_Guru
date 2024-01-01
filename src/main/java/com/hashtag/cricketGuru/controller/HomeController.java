package com.hashtag.cricketGuru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class HomeController {

    @GetMapping("/loginfile")
    public String home() {
        return "login"; // This refers to "home.html" in src/main/resources/templates
    }

    @GetMapping("/dashboardfile")
    public String dashboard(){
        return "dashboard";
    }
    @GetMapping("/registerfile")
    public String register(){
        return "register";
    }
    @GetMapping("/historyfile")
    public String history(){
        return "history";
    }
    @GetMapping("/static/style.css")
    public String style(){
        return "../static/style.css";
    }
    @GetMapping("/livefile")
    public String live(){
        return "live";
    }
    @GetMapping("/contact_usfile")
    public String contactus(){
        return "contact_us";
    }
}
