package com.shoppingcart.managementsystemn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.managementsystemn.dto.JwtTokenResponseDto;
import com.shoppingcart.managementsystemn.dto.LoginRequest;
import com.shoppingcart.managementsystemn.dto.UserRequestDto;
import com.shoppingcart.managementsystemn.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserRequestDto userDto)  {
		
		System.out.println("register user method is called");
		
		String response = userService.createUser(userDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
		
		System.out.println("login user method is called ");
		
	JwtTokenResponseDto response = userService.authenticateUser(request);
	
	  return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
