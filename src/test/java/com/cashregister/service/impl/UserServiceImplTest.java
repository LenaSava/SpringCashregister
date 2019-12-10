package com.cashregister.service.impl;

import com.cashregister.domain.User;
import com.cashregister.repository.UserRepo;
import com.cashregister.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepo;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addUser() {
        User u = new User();
        u.setUsername("Steve");
        when(userRepo.findByUsername("Steve")).thenReturn(u);

        String user = userService.addUser(u);

        verify(userRepo).findByUsername("Steve");

        assertNotNull(user);
    }
}