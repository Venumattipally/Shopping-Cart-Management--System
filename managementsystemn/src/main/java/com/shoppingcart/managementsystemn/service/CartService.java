package com.shoppingcart.managementsystemn.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
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
import com.shoppingcart.managementsystemn.repository.CartItemRepo;
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
	
	
	@Autowired
	private CartItemRepo cartItemRepo;
   @Autowired
	private ModelMapper mapper;
	
     public CartResponseDto addCart(String username, CartRequestDto request) {
		// TODO Auto-generated method stub
		
		UserEntity user  = userRepo.findByUsername(username).orElseThrow(() -> 
		                  new UsernameNotFoundException("user not found "));
		
		Product product = 	productRepo.findById(request.getProdcutId()).orElseThrow(() -> 
        new ProductNotFoundException("this product is not found"));
		
		Optional<Cart>  OptCart = cartRepo.findByUser(user);
		
		if(!OptCart.isPresent())
		{
			Cart cart =  new Cart();
			cart.setUser(user);
			cartRepo.save(cart);
		}
		Optional<CartItem> OptItem = cartItemRepo.findByProductAndUser(product,user);
		
		if(!OptItem.isPresent()) {
			
			CartItem cartItem =new CartItem(product,OptCart.get(),request.getQuantity(),product.getPrice());
			
		}
		else {
		CartItem item =  OptItem.get();
		item.setQuantity(item.getQuantity() + request.getQuantity());
		item.setTotalPrice(item.getQuantity() * product.getPrice());
		item.setCart(OptCart.get());
		cartItemRepo.save(item);
		}
			
		//neeed to calculte total price in the cart based on number of products and quantity
		
		return mapper.map(OptCart.get(), CartResponseDto.class);
		
			
	}
		
	 
}
