package com.jiechen.pojo;

import java.util.List;

public class UserOrder extends User {

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "orders=" + orders +
                '}';
    }
}
