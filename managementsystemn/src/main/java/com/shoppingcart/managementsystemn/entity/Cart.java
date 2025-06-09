package com.shoppingcart.managementsystemn.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

	@Column(name="cartItem_id")
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> cartItems =  new ArrayList();
	
	@Column(name="total_amount")
	private Double totalPrice;

	public Cart(UserEntity user, List<CartItem> cartItems, Double totalPrice) {
		super();
		this.user = user;
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
	}


	public Cart() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalProce) {
		this.totalPrice = totalProce;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", cartItems=" + cartItems + ", totalProce=" + totalPrice + "]";
	}
	
	
	
}
