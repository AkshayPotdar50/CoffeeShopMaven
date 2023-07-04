package com.java.model;

import java.util.ArrayList;
import java.util.*;

public class CoffeeShopApp {
    List<Drink> drinks;
    List<Customer> customers;

    public CoffeeShopApp(){
        this.drinks = new ArrayList<>();
        this.customers= new ArrayList<>();
    }

    public void run(){
        System.out.println("***********WELCOME TO COFFEE SHOP**********");
        Scanner scanner = new Scanner(System.in);
        String choice;
        do{
            System.out.println("A. Show drinks menu");
            System.out.println("B. Add drink to order");
            System.out.println("C. Remove drink from the order");
            System.out.println("D. Place order");
            System.out.println("E. Exit");
            System.out.println("Enter your choice (A-E):");
            choice=scanner.nextLine();

            switch (choice){
                case "A":
                    displayMenu();
                    break;
                case "B":
                    addDrinkToOrder();
                    break;
                case "C":
                    removeDrinkFromOrder();
                    break;
                case "D":
                    placeOrder();
                    break;
                case "E":
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again ");
            }
        }while (!choice.equals("E"));
    }

    public static void main(String[] args) {


    }

    private void displayMenu(){
        System.out.println("*******MENU********");
        for(int i=0; i<drinks.size();i++){
            Drink drink = drinks.get(i);
            System.out.println((i+1)+ ". " +drink.getName() +" $" +drink.getPrice());

        }
    }

    private void addDrinkToOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER YOUR NAME: ");
        String name =scanner.nextLine();
        System.out.println("Enter the drink name: " );
        String drinkName= scanner.nextLine();

        Customer customer = findCustomer(name);
        if(customer ==null){
            System.out.println("Customer not found . please create a customer profile");
            return;
        }

        Drink drink = findDrink(drinkName);
        if(drink==null){
            System.out.println("Drink not found please select from the menu ");
            return;
        }

        Order order = findOrCreateOrder(customer);
        order.addDrink(drink);
        System.out.println(drink.getName() + " added to " +customer.getName() +"'s order ");

    }
    private void removeDrinkFromOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name =scanner.nextLine();
        System.out.println("Enter drink name: ");
        String drinkName = scanner.nextLine();

        Customer customer = findCustomer(name);
        if(customer ==null){
            System.out.println("Customer not found please create a customer profile");
            return;
        }

        Drink drink = findDrink(drinkName);
        if(drink ==null){
            System.out.println("Drink not found. please select from menu");
            return;
        }

        Order order = findOrCreateOrder(customer);
        order.removeDrink(drink);
        System.out.println(drink.getName() +" removed from " +customer.getName() +"'s order");
    }

    private void placeOrder(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name =scanner.nextLine();

        Customer customer = findCustomer(name);
        if(customer==null){
            System.out.println("Customer not found. please create customer profile");
            return;
        }
        Order order = findOrder(customer);
        if(order ==null){
            System.out.println("No order found . please add drinks to your order");
            return;
        }
        order.displayReceipt();
        System.out.println((customer.getName() +"'s order placed successfully"));

    }
    private Order findOrCreateOrder(Customer customer) {
        Order order = findOrder(customer);
        if(order==null){
            order= new Order(customer);
            customer.getOrders().add(order);
        }
        return order;
    }

    private Drink findDrink(String drinkName) {
        for(Drink drink: drinks){
            if(drink.getName().equalsIgnoreCase(drinkName)){
                return drink;
            }
        }
        return null;
    }

    private Customer findCustomer(String name) {
        for(Customer customer:customers){
            if(customer.getName().equalsIgnoreCase(name)){
                return customer;
            }
        }
        return null;
    }

    private Order findOrder(Customer customer){
        for(Order order: customer.getOrders()){
            if(!order.getDrinks().isEmpty()){
                return order;
            }
        }
        return null;
    }

}
