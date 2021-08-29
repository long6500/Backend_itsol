package com.example.demo.Security.Service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    public EmployeeEntity getUserLogin() {
        CustomUserDetails login = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return login.getEmployee();
    }

    //    khong dung security
//    public EmployeeEntity fetchUserByUserNameAndPassword(String UserName, String password) {
//        return employeeRepository.findByUserNameAndPassword(UserName, password);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeEntity employee = new EmployeeEntity();
        try {
            employee = employeeRepository.findByUserName(username);
            return new CustomUserDetails(employee);
        } catch (NoResultException e) {
            logger.error("NoResultException:", e.getMessage());
        } finally {
            return new CustomUserDetails(employee);
        }
    }
}
