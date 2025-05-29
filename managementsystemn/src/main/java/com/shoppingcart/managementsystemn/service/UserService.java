package com.shoppingcart.managementsystemn.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.managementsystemn.dto.UserRequestDto;
import com.shoppingcart.managementsystemn.entity.UserEntity;
import com.shoppingcart.managementsystemn.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public String createUser(UserRequestDto userDto) {
		
		UserEntity user =  modelMapper.map(userDto, UserEntity.class);
		
		userRepo.save(user);
		
		return "user registered succesfully";
	}

}
