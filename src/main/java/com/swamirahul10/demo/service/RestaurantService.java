package com.swamirahul10.demo.service;

import com.swamirahul10.demo.pojo.Order;
import com.swamirahul10.demo.pojo.OrderStatus;
import com.swamirahul10.demo.repository.RestaurantRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public OrderStatus getOrderStatus(String orderId) {
        return restaurantRepository.getOrderStatus(orderId);
    }

    public JSONObject placeOrder(String itemId, Integer noOfItems) {
        return restaurantRepository.placeOrder(itemId, noOfItems);
    }

    public Order updateOrder(String orderId, String status) {
        return restaurantRepository.updateOrder(orderId, status);
    }

    public Order getOrder(String orderId) {
        return restaurantRepository.getOrder(orderId);
    }


}
