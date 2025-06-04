package com.shoppingcart.managementsystemn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.managementsystemn.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Integer>{

    Optional<UserEntity> findByUsername(String username);

}
