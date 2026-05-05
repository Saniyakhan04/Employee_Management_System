package com.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ems.security.JwtFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // blic endpoints
                .requestMatchers("/auth/**").permitAll()

                // le-based access
                .requestMatchers(HttpMethod.GET, "/employees/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/employees/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")

                // Any other request must be authenticated
                .anyRequest().authenticated()
            )
            //  Disable default login methods
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable())

            // d JWT filter
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}