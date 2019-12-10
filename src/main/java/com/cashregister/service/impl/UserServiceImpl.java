package com.cashregister.service.impl;

import com.cashregister.domain.User;
import com.cashregister.domain.type.Role;
import com.cashregister.repository.UserRepo;
import com.cashregister.service.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser() {

        try {
            return userRepo.findAll();
        } catch (RuntimeException e) {
            String errorMessage = String.format("cannot find users");
            throw new ServiceException(errorMessage);
        }

    }

    @Override
    public String addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return "registration";
        }
        user.setRole(Role.CAHIER);
        userRepo.save(user);

        return "redirect:/login";

    }
}
