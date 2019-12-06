package com.cashregister.service;

import com.cashregister.domain.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface UserService {

    List<User> getAllUser();

    String addUser(User user);

//    UserDetails loadUserByUsername(String username);

}
