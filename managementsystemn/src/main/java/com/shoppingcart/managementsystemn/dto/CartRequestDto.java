package com.shoppingcart.managementsystemn.dto;

import javax.validation.constraints.NotBlank;

public class CartRequestDto {
	
	@NotBlank(message="prodcut id should not be blank")
	private Integer prodcutId;
	
	@NotBlank(message="quantity should not be blank")
	private Integer Quantity;
	
	public CartRequestDto(Integer prodcutId, Integer quantity) {
		super();
		this.prodcutId = prodcutId;
		Quantity = quantity;
	}

	
	public Integer getProdcutId() {
		return prodcutId;
	}

	public void setProdcutId(Integer prodcutId) {
		this.prodcutId = prodcutId;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}


	@Override
	public String toString() {
		return "CartRequestDro [prodcutId=" + prodcutId + ", Quantity=" + Quantity + "]";
	}
	
   
}
