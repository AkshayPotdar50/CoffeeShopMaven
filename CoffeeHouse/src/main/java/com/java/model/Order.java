package com.java.model;

import java.util.*;

public class Order {
    private Customer customer;
    private List<Drink> drinks;

    public Order(Customer customer) {
        this.customer = customer;
        this.drinks = new ArrayList<>();
    }
    public Customer getCustomer() {
        return customer;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void removeDrink(Drink drink){
        drinks.remove(drink);
    }

    public double getTotalCost(){
        double total= 0.0;
        for(Drink drink :drinks){
            total+= drink.getPrice();
        }
        return total;
    }

    public void displayReceipt(){
        System.out.println("Order Receipt");
        System.out.println("Customer" +customer.getName());
        System.out.println("email" +customer.getEmail());
        System.out.println("Order:");
        for(Drink drink:drinks){
            System.out.println(drink.getName() +"  -$" + drink.getPrice());
        }
        System.out.println("Total:$" + getTotalCost());
    }



}
