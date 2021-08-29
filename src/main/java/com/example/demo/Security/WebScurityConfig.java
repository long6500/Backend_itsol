package com.example.demo.Security;

import com.example.demo.Security.JWT.AuthEntryPointJwt;
import com.example.demo.Security.JWT.AuthTokenFilter;
import com.example.demo.Security.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebScurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;


    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //    Basic-security
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("test7").password("Long6500").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("Admin");
//
//    }

    //    Basic-security
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

// Basic-security , security for all api
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//    }

    // Basic-security, based on url
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/auth/**").fullyAuthenticated().and().httpBasic();
    }

    // Basic-security, based on role
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/auth/**").hasAnyRole("Admin").anyRequest().fullyAuthenticated().and().httpBasic();
//    }


    //Chinh
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/auth/**")
//                .permitAll().anyRequest().authenticated();
////                .permitAll().and().formLogin();
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//    }

}
