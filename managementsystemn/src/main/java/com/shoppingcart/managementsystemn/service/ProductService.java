package com.shoppingcart.managementsystemn.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingcart.managementsystemn.dto.ProductDto;
import com.shoppingcart.managementsystemn.entity.Product;
import com.shoppingcart.managementsystemn.repository.ProductRepo;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;

	public ProductDto addProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		
		Product product = modelMapper.map(productDto,Product.class);
		
		productRepo.save(product);
		
		return productDto;
	}
	
	
	

}
