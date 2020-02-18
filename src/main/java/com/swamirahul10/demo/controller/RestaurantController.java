package com.swamirahul10.demo.controller;

import com.swamirahul10.demo.pojo.DeliveryPerson;
import com.swamirahul10.demo.pojo.OrderStatus;
import com.swamirahul10.demo.service.DeliveryPersonService;
import com.swamirahul10.demo.service.RestaurantService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;
import java.util.stream.Collectors;


@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @GetMapping("/getOrderStatus")
    public OrderStatus getOrderStatus(@RequestParam(value = "orderId") String orderId) {
        return restaurantService.getOrderStatus(orderId);
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam(value = "itemId") String itemId, @RequestParam(value = "noOfItems") Integer noOfItems) {
        return restaurantService.placeOrder(itemId, noOfItems).toString();
    }

    @PostMapping("/updateOrder")
    public String updateOrder(@RequestParam(value = "orderId") String orderId, @RequestParam(value = "status") String status) {
        return restaurantService.updateOrder(orderId, status).getStatus().getOrderStatus();
    }

    @GetMapping("/getActiveDeliveryPersons")
    public JSONArray getActiveDeliveryPersons() {
        return new JSONArray(deliveryPersonService.getActiveDeliveryPersons().stream().map(new Function<DeliveryPerson, JSONObject>() {
            @Override
            public JSONObject apply(DeliveryPerson deliveryPersonObj) {
                JSONObject deliveryPersonAsJson = new JSONObject();
                try {
                    deliveryPersonAsJson.put("Delivery Person Id", deliveryPersonObj.getDeliveryPersonId());
                    deliveryPersonAsJson.put("Delivery Person Status", deliveryPersonObj.getCurrentStatus().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return deliveryPersonAsJson;

            }
        }).collect(Collectors.toList()));
    }

}
