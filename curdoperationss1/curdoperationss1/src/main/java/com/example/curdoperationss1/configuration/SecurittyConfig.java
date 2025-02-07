package com.example.curdoperationss1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)  // Ensure pre-post annotations are enabled
public class SecurittyConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.withUsername("Gayathri")
                .password(passwordEncoder.encode("Gaya123"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("Gayathri1")
                .password(passwordEncoder.encode("Gaya1234"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity httpSec) throws Exception {
        return httpSec.csrf().disable()
                 .authorizeHttpRequests(auth -> auth
                        // Admin APIs
                        .requestMatchers("/api/admin/getAll","/api/admin/getById/{empId}").hasRole("ADMIN")
                       
                        // User APIs
                        .requestMatchers("/api/user/getAll").hasRole("USER")
                        // Other configurations
                        .anyRequest().authenticated()
                )
                .formLogin()  // Enable form-based login
                .and()
                .build();
    }
    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
        return httpSec.csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        // Admin APIs
                        .requestMatchers("/api/admin/manageUsers").hasRole("ADMIN")
                        .requestMatchers("/api/admin/systemStatus").hasRole("ADMIN")
                        // User APIs
                        .requestMatchers("/api/user/viewProfile").hasRole("USER")
                        // Other configurations
                        .anyRequest().authenticated()
                )
                .formLogin() // Enable form-based login
                .and()
                .build();
    }
*/
}
