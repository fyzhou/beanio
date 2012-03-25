package org.beanio.beans;

import java.util.*;

public class OrderBatch {

    private int batchCount;
    private List<Order> orders;
    
    public int getBatchCount() {
        return batchCount;
    }
    public void setBatchCount(int batchCount) {
        this.batchCount = batchCount;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public Order[] getOrderArray() {
        if (orders != null) {
            Order[] array = new Order[orders.size()];
            orders.toArray(array);
            return array;
        }
        return null;
    }
    public void setOrderArray(Order[] orderArray) {
        orders = Arrays.asList(orderArray);
    }
}