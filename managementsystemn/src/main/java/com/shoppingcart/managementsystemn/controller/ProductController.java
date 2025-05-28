package com.shoppingcart.managementsystemn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.managementsystemn.dto.ProductDto;
import com.shoppingcart.managementsystemn.entity.Product;
import com.shoppingcart.managementsystemn.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController 

{
	
	@Autowired
	private ProductService prodcutService;
	
	@PostMapping("/products")
	public ResponseEntity<?>  createProduct(@Valid @RequestBody ProductDto product)  {
		
		ProductDto productResponse = prodcutService.addProduct(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
	}
	
	@GetMapping("/products")
	public ResponseEntity<?>  getProducts()  {
		
		List<ProductDto> productResponse = prodcutService.getAllProducts();
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);
	}
	
	@PutMapping("/products{id}")
	public ResponseEntity<?> updateProductDetails(@PathVariable Integer id ,@RequestBody ProductDto product)
	{
		ProductDto productResponse = prodcutService.updateProduct(id,product);
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponse);

	}
}
