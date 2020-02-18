package com.swamirahul10.demo.pojo;

public enum DeliveryPersonStatus {
    FREE("Free"),
    BUSY("Busy"),
    ;

    private final String deliveryPersonStatus;

    private DeliveryPersonStatus(String deliveryPersonStatus) {
        this.deliveryPersonStatus = deliveryPersonStatus;
    }
}
