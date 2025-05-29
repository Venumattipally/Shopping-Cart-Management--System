package com.shoppingcart.managementsystemn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.managementsystemn.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Integer>{

}
