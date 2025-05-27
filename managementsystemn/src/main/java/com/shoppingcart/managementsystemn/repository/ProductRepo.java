package com.shoppingcart.managementsystemn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.managementsystemn.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
