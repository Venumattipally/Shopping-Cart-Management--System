package com.shoppingcart.managementsystemn.cofig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShoppingCartAppConfig {
	
	@Bean
	public ModelMapper moderlMapper()  {
		return new ModelMapper();
	}

}
