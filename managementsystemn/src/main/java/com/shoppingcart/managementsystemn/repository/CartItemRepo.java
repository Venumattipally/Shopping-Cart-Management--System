package com.shoppingcart.managementsystemn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.managementsystemn.entity.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem,Integer>{

}
