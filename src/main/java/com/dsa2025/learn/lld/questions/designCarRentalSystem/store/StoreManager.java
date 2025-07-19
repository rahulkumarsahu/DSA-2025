package com.dsa2025.learn.lld.questions.designCarRentalSystem.store;

import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.enums.VehicleStatus;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class StoreManager {

    private List<Vehicle> vehicles;

    public StoreManager() {
        this.vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    //to add the vehicle
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getModelName());
    }

    // to delete the vehicle
    public void delete(String vehicleId) {
        vehicles.removeIf(v -> v.getId().equals(vehicleId));
        System.out.println("Vehicle deleted: " + vehicleId);
    }

    // to update the vehicle
    public void update(Vehicle vehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId().equals(vehicle.getId())) {
                vehicles.set(i, vehicle);
                System.out.println("Vehicle updated: " + vehicle.getModelName());
                return;
            }
        }
    }

    public void read() {
        System.out.println("\n📋 ALL VEHICLES:");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println("  " + v);
        }
    }

    public Vehicle findVehicle(String vehicleId) {
        return vehicles.stream()
                .filter(v -> v.getId().equals(vehicleId))
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(Vehicle::isAvailable)
                .toList();
    }

    public List<Vehicle> getReservedVehicles() {
        return vehicles.stream()
                .filter(v -> v.getStatus() == VehicleStatus.RESERVED)
                .toList();
    }

    public void showRemainingVehicles() {
        List<Vehicle> available = getAvailableVehicles();
        List<Vehicle> reserved = getReservedVehicles();

        System.out.println("VEHICLE AVAILABILITY STATUS:");
        System.out.println("═══════════════════════════════");

        System.out.println("AVAILABLE VEHICLES (" + available.size() + "):");
        if (available.isEmpty()) {
            System.out.println("No vehicles available");
        } else {
            for (Vehicle v : available) {
                System.out.println("  ✓ " + v.getVehicleType() + " - " + v.getModelName() +
                        " (" + v.getRegistrationNumber() + ")");
            }
        }

        System.out.println("RESERVED VEHICLES (" + reserved.size() + "):");
        if (reserved.isEmpty()) {
            System.out.println("  ✓ No vehicles currently reserved");
        } else {
            for (Vehicle v : reserved) {
                System.out.println(v.getVehicleType() + " - " + v.getModelName() +
                        " (" + v.getRegistrationNumber() + ") [RESERVED]");
            }
        }

        System.out.println("  SUMMARY:");
        System.out.println("  Total Vehicles: " + vehicles.size());
        System.out.println("  Available: " + available.size());
        System.out.println("  Reserved: " + reserved.size());
        System.out.println("═══════════════════════════════");
    }
}
