package com.shoppingcart.managementsystemn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.managementsystemn.entity.Cart;

public interface CartRepo extends JpaRepository<Cart,Integer> {

}
