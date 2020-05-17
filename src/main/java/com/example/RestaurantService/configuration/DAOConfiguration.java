package com.example.RestaurantService.configuration;

import com.example.RestaurantService.dao.ItemDAO;
import com.example.RestaurantService.dao.OrderDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfiguration {
    @Bean
    public ItemDAO getItemDAO() {
        return new ItemDAO();
    }

    @Bean
    public OrderDAO getOrderDAO() {
        return new OrderDAO();
    }
}
