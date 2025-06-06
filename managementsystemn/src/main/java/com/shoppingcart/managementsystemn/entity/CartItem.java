package com.shoppingcart.managementsystemn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	public CartItem(Integer id, Product product, Cart cart, Integer quantity, Double totalPrice) {
		super();
		Id = id;
		this.product = product;
		this.cart = cart;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public CartItem(Product product2, Cart cart2, Integer quantity2, Double totalPrice2) {
		
		super();
	
		this.product = product2;
		this.cart = cart2;
		this.quantity = quantity2;
		this.totalPrice = totalPrice2;
		
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [Id=" + Id + ", product=" + product + ", cart=" + cart + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	
}
