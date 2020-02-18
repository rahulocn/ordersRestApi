package com.swamirahul10.demo.repository;

import com.swamirahul10.demo.pojo.Item;
import com.swamirahul10.demo.pojo.Order;
import com.swamirahul10.demo.pojo.OrderStatus;
import com.swamirahul10.demo.service.DeliveryPersonService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RestaurantRepository {
    private final ConcurrentHashMap<String, Order> orders = new ConcurrentHashMap<>();

    @Autowired
    DeliveryPersonService deliveryPersonService;

    public OrderStatus getOrderStatus(String orderStatus) {
        Order order = orders.get(orderStatus);
        if (order != null)
            return order.getStatus();
        else return OrderStatus.ORDER_NOT_FOUND;
    }

    public JSONObject placeOrder(String itemId, Integer noOfItems) {
        Order order = new Order(Duration.ofHours(5), new Item(itemId), noOfItems);
        JSONObject jsonResponse = new JSONObject();
        orders.put(order.getOrderId(), order);
        try {
            jsonResponse.put("orderId", order.getOrderId());
            jsonResponse.put("orderStatus", order.getStatus().getOrderStatus());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

    public Order updateOrder(String orderId, String status) {
        Order order = orders.get(orderId);
        order.setStatus(OrderStatus.fromString(status));
        return order;
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

}

