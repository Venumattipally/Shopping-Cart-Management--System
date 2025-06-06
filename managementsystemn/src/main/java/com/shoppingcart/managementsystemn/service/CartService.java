package com.shoppingcart.managementsystemn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppingcart.managementsystemn.dto.CartRequestDto;
import com.shoppingcart.managementsystemn.dto.CartResponseDto;
import com.shoppingcart.managementsystemn.entity.Cart;
import com.shoppingcart.managementsystemn.entity.CartItem;
import com.shoppingcart.managementsystemn.entity.Product;
import com.shoppingcart.managementsystemn.entity.UserEntity;
import com.shoppingcart.managementsystemn.exception.CartAlreadyExistException;
import com.shoppingcart.managementsystemn.exception.ProductNotFoundException;
import com.shoppingcart.managementsystemn.repository.CartRepo;
import com.shoppingcart.managementsystemn.repository.ProductRepo;
import com.shoppingcart.managementsystemn.repository.UserRepo;

@Service
public class CartService {
	
	
	@Autowired
    private UserRepo userRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProductRepo productRepo;

	public CartResponseDto addCart(String username, CartRequestDto request) {
		// TODO Auto-generated method stub
		
		UserEntity user  = userRepo.findByUsername(username).orElseThrow(() -> 
		                  new UsernameNotFoundException("user not found "));
		
		if(!cartRepo.existByUser(user)) {
			
			throw new CartAlreadyExistException("Cart is already created for this user");
		}
		
	Product product = 	productRepo.findById(request.getProdcutId()).orElseThrow(() -> 
	                                           new ProductNotFoundException("this product is not found"));
	
	
	
	Cart cart = new Cart();
	CartItem cartItem =  new CartItem( product,cart,request.getQuantity(),product.getPrice());
	
		
		
	
		
	}

}
