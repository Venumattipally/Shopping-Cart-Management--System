package com.shoppingcart.managementsystemn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.managementsystemn.entity.Cart;
import com.shoppingcart.managementsystemn.entity.UserEntity;

public interface CartRepo extends JpaRepository<Cart,Integer> {

	boolean existByUser(UserEntity user);

}
