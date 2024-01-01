package com.hashtag.cricketGuru.controller;


import com.hashtag.cricketGuru.model.Role;
import com.hashtag.cricketGuru.model.User;
import com.hashtag.cricketGuru.model.UserRole;
import com.hashtag.cricketGuru.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/dashboard")
//    @PreAuthorize("hasAuthority('NORMAL')")
//    public String dashboard(){
//        return "USER DASHBOARD";
//    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('NORMAL')")
    public String getAdmin(){
        return  "Normal User Dashboard";
    }


    @GetMapping("/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NORMAL')")
    public ResponseEntity<?> getUser (@PathVariable("username") String username){
//        return this.userService.getUser(username);
        User users= userService.getUser(username);
        if(users==null){
            return ResponseEntity.badRequest().body("Bad Request");
        }else{
        return ResponseEntity.ok(userService.getUser(username));
        }
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user) throws Exception {
//        return userService.cr(user);
//    }

//    @PostMapping("/login")
//    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) throws Exception {
//        return authService.loginUserService(loginRequest);
//    }
}
