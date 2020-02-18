package com.swamirahul10.demo.controller;

import com.swamirahul10.demo.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @PostMapping("/delegateOrder")
    public String delegateOrder(@RequestParam(value = "orderId") String orderId, @RequestParam(value = "deliveryPersonId") String deliveryPersonId) {
        return deliveryPersonService.delegateOrder(orderId, deliveryPersonId);
    }

    @GetMapping("/getDeliveryPersonStatus")
    public String getDeliveryPersonStatus(@RequestParam(value = "deliveryPersonId") String deliveryPersonId) {

        //return deliveryPersonService.getDeliveryPersonStatus(deliveryPersonId);
        return null;
    }

}
