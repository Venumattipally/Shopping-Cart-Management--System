package com.shoppingcart.managementsystemn.exception;

public class CartAlreadyExistException extends RuntimeException {
	
	private String message;
	
	public CartAlreadyExistException(String message ) {
		this.message = message;
	}

}
