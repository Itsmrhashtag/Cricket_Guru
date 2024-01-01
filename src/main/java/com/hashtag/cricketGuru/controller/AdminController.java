package com.hashtag.cricketGuru.controller;



import com.hashtag.cricketGuru.model.Role;
import com.hashtag.cricketGuru.model.User;
import com.hashtag.cricketGuru.model.UserRole;
import com.hashtag.cricketGuru.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAdmin(){
        return  "ADMIN Dashboard";
    }


}
