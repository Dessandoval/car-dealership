package com.pluralsight;

import java.math.BigDecimal;

public class Program {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(12332, 2019, "Ford", "Bronco", "Suv", "Red", 25000, new BigDecimal("20.00"));
        System.out.println(vehicle);
    }
}
