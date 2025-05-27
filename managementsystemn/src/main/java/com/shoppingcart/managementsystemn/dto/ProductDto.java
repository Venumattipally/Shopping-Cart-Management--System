package com.shoppingcart.managementsystemn.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto {
		
	@NotBlank(message ="product name is required")
	@Size(min = 3,max = 100)
	private String name;
	
	@DecimalMin(value = "0.01",message="price should be greater than 0")
	private Double price;
	
	@NotBlank(message="description is requireed")
	@Size(max=500)
	private String Description;
	
	@Min(value =0,message = "product quantity should not be negative ")
	private Integer stock;
	
	
	

	public ProductDto( String name, Double price, String description, Integer stock) {
		super();
		this.name = name;
		this.price = price;
		Description = description;
		this.stock = stock;
	}
	
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}




	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", price=" + price + ", Description=" + Description + ", stock=" + stock
				+ "]";
	}


	
	
}
