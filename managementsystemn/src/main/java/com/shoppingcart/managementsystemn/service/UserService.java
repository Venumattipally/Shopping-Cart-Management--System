package com.shoppingcart.managementsystemn.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoppingcart.managementsystemn.dto.JwtTokenResponseDto;
import com.shoppingcart.managementsystemn.dto.LoginRequest;
import com.shoppingcart.managementsystemn.dto.UserRequestDto;
import com.shoppingcart.managementsystemn.entity.UserEntity;
import com.shoppingcart.managementsystemn.jwt.JwtUtil;
import com.shoppingcart.managementsystemn.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager manager;

	public String createUser(UserRequestDto userDto) {
		
		System.out.println("create user method is called ");
		UserEntity user =  new UserEntity();
		System.out.println(userDto);
		
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setPhoneNo(userDto.getPhoneNo());
		user.setUsername(userDto.getUsername());
		
		userRepo.save(user);
		
		return "user registered succesfully";
	}

	public JwtTokenResponseDto authenticateUser(LoginRequest request) {
		
		Authentication authentication =  manager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword()));
		
		if(authentication.isAuthenticated())           {
			
			Optional<UserEntity> optUser =  userRepo.findByUsername(request.getUsername());
			if(optUser.isPresent()) {
				
				UserEntity user =  optUser.get();
				
				return new JwtTokenResponseDto(user.getUsername(),user.getPassword(),jwtUtil.generateToken(user.getUsername()));
			}
		}
		
		return new JwtTokenResponseDto(null, null, null);
	}

}
