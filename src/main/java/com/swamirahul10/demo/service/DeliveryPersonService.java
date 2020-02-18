package com.swamirahul10.demo.service;

import com.swamirahul10.demo.pojo.DeliveryPerson;
import com.swamirahul10.demo.repository.DeliveryPersonRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPersonService {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    public String delegateOrder(String orderId, String deliveryPersonId) {
        return deliveryPersonRepository.delegateOrder(orderId, deliveryPersonId);
    }

    public List<DeliveryPerson> getActiveDeliveryPersons() {
        return deliveryPersonRepository.getActiveDeliveryPersons();
    }

    public JSONObject getDeliveryPersonStatus(String deliveryPersonId) {
        return deliveryPersonRepository.getDeliveryPersonStatus(deliveryPersonId);
    }
}
