package com.hashtag.cricketGuru.controller;

import com.hashtag.cricketGuru.model.Role;
import com.hashtag.cricketGuru.model.User;
import com.hashtag.cricketGuru.model.UserRole;
import com.hashtag.cricketGuru.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class NormalController {


    @Autowired
    private UserService userService;
    @GetMapping("/dashboard")
    public String getAdmin(){
        return  "For all Dashboard";
    }


    @PostMapping("/admin/register")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");

        Set<UserRole> roles= new HashSet<>();
        Role role =new Role();
        role.setRoleId(44L);
        role.setRoleName("ADMIN");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);


        roles.add(userRole);

        return this.userService.createUser(user,roles);

    }
    @PostMapping("/register")
    public User createUserNormal(@RequestBody User user) throws Exception {

        user.setProfile("default.png");

        Set<UserRole> roles= new HashSet<>();
        Role role =new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);


        roles.add(userRole);

        return this.userService.createUser(user,roles);

    }
}
