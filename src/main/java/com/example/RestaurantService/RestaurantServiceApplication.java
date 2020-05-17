package com.example.RestaurantService;

import com.example.RestaurantService.dao.ItemRepository;
import com.example.RestaurantService.model.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDatabase(ItemRepository itemRepository) {
		return (args) -> {
			// Initialize a few items
			itemRepository.save(Item.builder().id("Samosa").price(10.0).build());
			itemRepository.save(Item.builder().id("Kachori").price(10.0).build());
			itemRepository.save(Item.builder().id("VegRoll").price(30.0).build());
		};
	}
}
