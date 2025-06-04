package com.shoppingcart.managementsystemn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppingcart.managementsystemn.entity.UserEntity;
import com.shoppingcart.managementsystemn.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		     UserEntity user =  userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
		     
		     
		      
		return new CustomUserDetails(user);
	}

}
