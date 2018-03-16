package com.jiechen.pojo;

public class OrderUser2 extends Order {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderUser2{" +
                "user=" + user +
                '}';
    }
}
