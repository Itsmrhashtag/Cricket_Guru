package com.hashtag.cricketGuru.services.impl;



import com.hashtag.cricketGuru.model.User;
import com.hashtag.cricketGuru.model.UserRole;
import com.hashtag.cricketGuru.repo.RoleRepository;
import com.hashtag.cricketGuru.repo.UserRepository;
import com.hashtag.cricketGuru.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

//    creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local !=null){
            System.out.println("User is already there !!");
            throw new Exception("User already present !!");
        }else{
            String rawPassword = user.getPassword();
            String encodedPassword = passwordEncoder.encode(rawPassword);
            user.setPassword(encodedPassword);
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local =this.userRepository.save(user);
            System.out.println(local.getAuthorities());
        }

        return local;
    }

    @Override
    public User getUser(String username) {
        if (userRepository.findByUsername(username) == null) {
            System.out.println("No User......................................");
            return null;
        }else{
        return  this.userRepository.findByUsername(username);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
    //geting user by username
//    @Override
//    public User getUser(String username){
//        return  this.userRepository.findByUsername(username);
//    }
}
