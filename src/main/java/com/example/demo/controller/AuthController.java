package com.example.demo.controller;

import com.example.demo.Security.JWT.JwtUtils;
import com.example.demo.Security.Service.CustomUserDetails;
import com.example.demo.Security.Service.CustomUserDetailsService;
import com.example.demo.message.request.LoginRequest;
import com.example.demo.message.response.JwtResponse;
import com.example.demo.model.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);


//    Basic-security
//    @GetMapping("/signin")
//    public String login() {
//        System.err.println("CHAY VAO DAY");
//        return "authen sucessfully";
//    }

//    1 - luc dau la GetMapping
//    @PostMapping("/signin")
//    public EmployeeEntity basicauth() {
//        System.err.println("NHOM 1");
//        return customUserDetailsService.getUserLogin();
//    }
//1 - sau khi update
//    @PostMapping(path = "/signin", produces = "application/json")
//    public ResponseEntity<?> generateAuthenticationToken(@RequestBody LoginRequest jwtRequest) {
//        JwtResponse response= authenticationService.authenticate(jwtRequest);
////        if(ObjectUtil.isEmpty(response))return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return ResponseEntity.ok(response);
//    }

//    khong dung security
//    @PostMapping("/signin")
//    public EmployeeEntity loginUser(@RequestBody EmployeeEntity user) throws Exception {
//        String tempUsername = user.getUserName();
//        String tempPass = user.getPassword();
//        EmployeeEntity userObj = null;
//        if (tempUsername != null && tempPass != null) {
//            userObj = customUserDetailsService.fetchUserByUserNameAndPassword(tempUsername, tempPass);
//        }
//        if (userObj == null) {
//            throw new Exception("Bad Credentials");
//        }
//        return userObj;
//    }


    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.err.println("CHAY VAO Sign In");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getEmployee().getId(),
                userDetails.getEmployee().getUserName(),
                userDetails.getEmployee().getRole()));

    }

//    2
//    @GetMapping("/signin")
//    public Principal login(Principal principal) {
//        logger.info("user logged: " + principal);
//        return principal;
//    }


}
