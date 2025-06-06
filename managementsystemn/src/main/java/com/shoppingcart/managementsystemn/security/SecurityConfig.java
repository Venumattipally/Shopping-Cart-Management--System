package com.shoppingcart.managementsystemn.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shoppingcart.managementsystemn.jwt.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securtiyFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf().disable()
		    .authorizeHttpRequests(auth -> auth.antMatchers("/api/user/signup").permitAll()
		    		                      .anyRequest().authenticated())
		   
		    .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
		    
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
