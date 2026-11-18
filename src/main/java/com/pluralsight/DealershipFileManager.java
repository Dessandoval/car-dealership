package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {


    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] dealershipParts = line.split("\\|");
                dealership = new Dealership(dealershipParts[0], dealershipParts[1], dealershipParts[2]);
            }

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                BigDecimal price = new BigDecimal(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                if (dealership != null) {
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException e) {
            System.out.println("Error could not read inventory: " + e.getMessage());
        }

        return dealership;

    }
    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber() + "\n");
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType()
                        + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error! Inventory could not be saved.");
        }
    }
}
