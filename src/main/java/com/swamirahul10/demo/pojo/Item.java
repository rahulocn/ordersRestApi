package com.swamirahul10.demo.pojo;

import java.util.Objects;

public class Item {
    public Item() {
    }

    public Item(String itemId) {
        this.itemId = itemId;
    }

    private String itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                +'\'' +
                '}';
    }

    public String getItemId() {
        return itemId;
    }


}
