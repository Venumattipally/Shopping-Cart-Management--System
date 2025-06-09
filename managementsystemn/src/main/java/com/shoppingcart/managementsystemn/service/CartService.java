package com.shoppingcart.managementsystemn.service;

import java.util.Iterator;
import java.util.List;
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
		System.out.println(user);
		Product product = 	productRepo.findById(request.getProdcutId()).orElseThrow(() -> 
        new ProductNotFoundException("this product is not found"));
		
		Optional<Cart>  OptCart = cartRepo.findByUser(user);
		Cart cart =  null;;   
		if(!OptCart.isPresent())
		{
			 cart =  OptCart.get();
			cart.setUser(user);
			cartRepo.save(cart);
		}
		Optional<CartItem> OptItem = cartItemRepo.findByProductAndCart(product,cart);
		
		if(!OptItem.isPresent()) {
			
			CartItem cartItem =new CartItem(product,cart,request.getQuantity(),product.getPrice());
			
		}
		else {
		CartItem item =  OptItem.get();
		item.setQuantity(item.getQuantity() + request.getQuantity());
		item.setTotalPrice(item.getQuantity() * product.getPrice());
		item.setCart(cart);
		cartItemRepo.save(item);
		}
			
		//neeed to calculte total price in the cart based on number of products and quantity
		
	 /* List<CartItem> items =  cart.getCartItems();
		Double sum =0.0;
	   for(CartItem item : items) {
		   
		   sum =  sum + item.getTotalPrice();
	   }*/
		
		
		return mapper.map(cart, CartResponseDto.class);
		
			
	}
		
	 
}
