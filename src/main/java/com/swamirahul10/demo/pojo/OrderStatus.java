package com.swamirahul10.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.stream.Stream;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatus {
    UNASSIGNED("Unassigned"),
    IN_TRANSIT("In Transit"),
    DELIVERED("Delivered"),
    ORDER_NOT_FOUND("Order Not Found");

    private final String orderStatus;

    private OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public static OrderStatus fromString(String fromStatus) {
        return Stream.of(OrderStatus.values()).filter(eachOrderStatus -> eachOrderStatus.orderStatus.equalsIgnoreCase(fromStatus)).findFirst().get();
    }
}
