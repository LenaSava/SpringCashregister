package com.cashregister.domain.type;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CAHIER, SENIOR_CASHIER, MANAGER,VIZITOR;


    @Override
    public String getAuthority() {
        return name();
    }
}