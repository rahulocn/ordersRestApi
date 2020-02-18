package com.swamirahul10.demo.pojo;

import java.util.Objects;

public class DeliveryPerson {
    private final String deliveryPersonId;
    private String assignedOrder;

    private DeliveryPersonStatus currentStatus;

    public DeliveryPerson(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryPerson that = (DeliveryPerson) o;
        return Objects.equals(deliveryPersonId, that.deliveryPersonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryPersonId);
    }

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public String getAssignedOrder() {
        return assignedOrder;
    }

    public void setAssignedOrder(String assignedOrder) {
        this.assignedOrder = assignedOrder;
    }

    public void setCurrentStatus(DeliveryPersonStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public boolean isAvailable() {
        return currentStatus.equals(DeliveryPersonStatus.FREE);
    }

    public DeliveryPersonStatus getCurrentStatus() {
        return currentStatus;
    }
}
