package com.swamirahul10.demo.repository;

import com.swamirahul10.demo.pojo.DeliveryPerson;
import com.swamirahul10.demo.pojo.DeliveryPersonStatus;
import com.swamirahul10.demo.pojo.Order;
import com.swamirahul10.demo.pojo.OrderStatus;
import com.swamirahul10.demo.service.RestaurantService;
import com.swamirahul10.demo.utils.DateTimeUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class DeliveryPersonRepository {
    private final ConcurrentHashMap<String, DeliveryPerson> deliveryPersons = new ConcurrentHashMap<>();

    @Autowired
    RestaurantService restaurantService;


    public List<DeliveryPerson> getActiveDeliveryPersons() {
        return deliveryPersons.values().parallelStream().filter(DeliveryPerson::isAvailable).collect(Collectors.toList());
    }

    public String delegateOrder(String orderId, String deliveryPersonId) {
        DeliveryPerson deliveryPerson = deliveryPersons.get(deliveryPersonId);
        deliveryPerson.setAssignedOrder(orderId);
        deliveryPerson.setCurrentStatus(DeliveryPersonStatus.BUSY);
        restaurantService.updateOrder(orderId, OrderStatus.IN_TRANSIT.getOrderStatus());
        JSONObject acceptedOrder = new JSONObject();
        try {
            acceptedOrder.put("status", "Accepted");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return acceptedOrder.toString();
    }


    public JSONObject getDeliveryPersonStatus(String deliveryPersonId) {
        DeliveryPerson deliveryPerson = deliveryPersons.get(deliveryPersonId);
        JSONObject response = new JSONObject();
        try {
            response.put("status", deliveryPerson.getCurrentStatus().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!deliveryPerson.isAvailable()) {
            Order orderbeingServed = restaurantService.getOrder(deliveryPerson.getAssignedOrder());
            Duration timeDuration = Duration.between(orderbeingServed.getOrderPlacedTime().plus(orderbeingServed.getTimeRequired()), LocalDateTime.now());
            String timeRemaining = DateTimeUtils.formatDuration(timeDuration);
            try {
                response.put("Time Remaining", timeRemaining);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return response;
    }

}

