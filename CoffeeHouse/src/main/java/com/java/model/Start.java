package com.java.model;

import java.util.Scanner;

/*
For detailed instructions, please refer to the README file.
It contains all the necessary guidelines and information for submitting and working with this project.
 */

public class Start {
    //you may remove the static keyword if required, and please DO NOT CREATE a new object for scanner class


    public static void main(String[] args) {
        CoffeeShopApp coffeeShopApp = new CoffeeShopApp();

        //sample drinks
        coffeeShopApp.drinks.add( new Drink("Espresso", 2.5));
        coffeeShopApp.drinks.add(new Drink("Cappuccino", 3.0));
        coffeeShopApp.drinks.add(new Drink("Latte", 3.5));

        //sample customers
        coffeeShopApp.customers.add(new Customer("Akshay", "akshay50@gmail.com"));

        coffeeShopApp.run();  //calling run method to run business logic
    }
}
