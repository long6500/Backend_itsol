package com.example.demo.Security.Service;

import com.example.demo.model.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private EmployeeEntity employee;
    public CustomUserDetails(EmployeeEntity employee) {
        this.employee = employee;
    }
    public EmployeeEntity getEmployee() {
        return employee;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(employee.getRole()));
    }
    @Override
    public String getPassword() {
        return employee.getPassword();
    }
    @Override
    public String getUsername() {
        return employee.getUserName();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
