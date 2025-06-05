package com.shoppingcart.managementsystemn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_items")
public class CartItem {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
    
	@JoinColumn(name="product_id")
	@ManyToOne
    private Product product;
	
	@JoinColumn(name="cart_id")
	@ManyToOne
	private Cart cart;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="totalPrice")
	private Double totalPrice;
}
