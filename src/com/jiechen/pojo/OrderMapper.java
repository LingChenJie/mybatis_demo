package com.jiechen.pojo;

import java.util.List;

public interface OrderMapper {

    /**
     * 查询所有订单
     */
    List<Order> queryOrderAll();


    /**
     * 一对一关联，查询订单信息包含用户信息
     */
    List<OrderUser> queryOrderUser();

    /**
     * 一对一关联，订单内部包含属性
     */
    List<OrderUser2> queryOrderUserResultMap();
}
