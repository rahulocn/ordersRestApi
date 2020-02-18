package com.swamirahul10.demo.pojo;

import com.swamirahul10.demo.utils.GenerateIds;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private final String orderId;
    private final Duration timeRequired;
    private final LocalDateTime orderPlacedTime;
    private OrderStatus status;
    private final Item item;
    private final Integer quantity;

    public Order(Duration timeRequired, Item itemId, int quantity) {
        this.timeRequired = timeRequired;
        this.orderId = GenerateIds.generateOrderID();
        this.status = OrderStatus.UNASSIGNED;
        this.orderPlacedTime = LocalDateTime.now();
        this.item = itemId;
        this.quantity = quantity;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId.equals(order.orderId) &&
                Objects.equals(timeRequired, order.timeRequired) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    public String getOrderId() {
        return orderId;
    }

    public Duration getTimeRequired() {
        return timeRequired;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderPlacedTime() {
        return orderPlacedTime;
    }
}
