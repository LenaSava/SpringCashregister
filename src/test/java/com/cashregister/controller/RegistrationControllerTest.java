package com.cashregister.controller;

import com.cashregister.domain.User;
import com.cashregister.domain.type.Role;
import com.cashregister.repository.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.cashregister.domain.type.Role.CAHIER;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationControllerTest {

    @Autowired
    private RegistrationController registrationController;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void addUser() {
        User user = new User();

        Assert.assertTrue(CoreMatchers.is(user.getRole()).matches(CAHIER));
    }
}