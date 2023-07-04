package com.java.model;
import java.util.*;
public class Customer {

    private String name;
    private String email;

   private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order){
        orders.add(order);
}

   public void removeOrder(Order order){
        orders.remove(order);
   }

    public Order getOrder(int index){
        if(index>= 0&& index <orders.size()){
            return orders.get(index);
        }else{
            return null;
        }
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
