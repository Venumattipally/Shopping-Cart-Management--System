package com.shoppingcart.managementsystemn.security;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
		    .authorizeHttpRequests(auth -> auth.antMatchers("/api/user/signup","/api/user/login").permitAll()
		    		                      .anyRequest().authenticated())
		   
		    .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
		    
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authManager() {
	
			
		return new AuthenticationManager() {
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				// TODO Auto-generated method stub
				return authentication;
			}
		};
	}
	

}

