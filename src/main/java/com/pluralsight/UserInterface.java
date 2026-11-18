package com.pluralsight;


import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void display() {
        init();

        while (true) {
            displayMenu();
        }
    }

    private void displayMenu() {
        System.out.println("\n=== " + dealership.getName() + " ===");
        System.out.println("1. Find by Price");
        System.out.println("2. Find by Make / Model");
        System.out.println("3. Find by Year");
        System.out.println("4. Find by Color");
        System.out.println("5. Find by Mileage");
        System.out.println("6. Find by Type");
        System.out.println("7. List All Vehicles");
        System.out.println("8. Add a Vehicle");
        System.out.println("9. Remove a Vehicle");
        System.out.println("99. Quit");
        System.out.print("Enter choice: ");
    }

}