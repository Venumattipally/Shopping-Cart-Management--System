package com.shoppingcart.managementsystemn.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductDto>  productsDto =  new ArrayList();
		List<Product> products = productRepo.findAll();
		for(Product product : products) {
			ProductDto productDto =  new ProductDto(product.getName(), product.getPrice(), 
					product.getDescription(), product.getStock());
			productsDto.add(productDto);
		}
		
		return productsDto;
		
	}

	public ProductDto updateProduct(Integer id, ProductDto product) {
		// TODO Auto-generated method stub
		
		Product oldProduct = productRepo.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
		
		oldProduct.setDescription(product.getDescription());
		oldProduct.setName(product.getName());
		oldProduct.setPrice(product.getPrice());
		oldProduct.setStock(product.getStock());
		
		productRepo.save(oldProduct);
	
		return product;
	}
	
	
	

}
