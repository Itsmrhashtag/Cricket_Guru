package com.hashtag.cricketGuru.services.impl;



import com.hashtag.cricketGuru.model.Role;
import com.hashtag.cricketGuru.model.User;
import com.hashtag.cricketGuru.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);
       User user = this.userRepository.findByUsername(username);
       if(user==null){
           System.out.println("User not found");
           throw new UsernameNotFoundException("No user found  !!");
       }
        return user;
    }

    private Collection<? extends GrantedAuthority>mapRolestoAuthorities(Set<Role> roles){
        return  roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
