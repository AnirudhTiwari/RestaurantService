package com.example.RestaurantService.configuration;

import com.example.RestaurantService.dao.ItemDao;
import com.example.RestaurantService.dao.OrderDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {
    @Bean
    public ItemDao getItemDAO() {
        return new ItemDao();
    }

    @Bean
    public OrderDao getOrderDAO() {
        return new OrderDao();
    }
}
