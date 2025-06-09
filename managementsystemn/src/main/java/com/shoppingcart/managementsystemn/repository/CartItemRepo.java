package com.shoppingcart.managementsystemn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.managementsystemn.entity.CartItem;
import com.shoppingcart.managementsystemn.entity.Product;
import com.shoppingcart.managementsystemn.entity.UserEntity;

public interface CartItemRepo extends JpaRepository<CartItem,Integer>{

	Optional<CartItem> findByProduct(Product product);

	Optional<CartItem> findByProductAndUser(Product product,UserEntity user);

} 
