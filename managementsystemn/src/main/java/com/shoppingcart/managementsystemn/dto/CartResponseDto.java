package com.shoppingcart.managementsystemn.dto;

import com.shoppingcart.managementsystemn.entity.Cart;

public class CartResponseDto {
	
	private String message;
	private Cart cart;
	private Double totalAmount;
	
	
	public CartResponseDto(String message, Cart cart, Double totalAmount) {
		super();
		this.message = message;
		this.cart = cart;
		this.totalAmount = totalAmount;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	@Override
	public String toString() {
		return "CartResponseDto [message=" + message + ", cart=" + cart + ", totalAmount=" + totalAmount + "]";
	}
	
	
    
}
