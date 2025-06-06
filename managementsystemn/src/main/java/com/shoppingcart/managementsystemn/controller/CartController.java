package com.shoppingcart.managementsystemn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.managementsystemn.dto.CartRequestDto;
import com.shoppingcart.managementsystemn.dto.CartResponseDto;
import com.shoppingcart.managementsystemn.service.CartService;
import com.shoppingcart.managementsystemn.service.CustomUserDetails;

@RestController
@RequestMapping("api")
public class CartController {
   
	@Autowired
	private CartService cartervice;
	
	@PostMapping("/cart/add")
	public ResponseEntity<?> createCart(@RequestBody CartRequestDto  request,
			        @AuthenticationPrincipal CustomUserDetails userDetails) {
		
		String username =  userDetails.getUsername();
		
		CartResponseDto response =  cartervice.addCart(username,request);
		return ResponseEntity.status(HttpStatus.OK).body(response);	}
	
}
