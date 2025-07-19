package com.dsa2025.learn.lld.questions.designCarRentalSystem;

import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.vehicle.Bike;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.vehicle.Car;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.location.Location;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.user.User;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.reservation.Reservation;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.reservation.ReservationSystem;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.store.Store;

import java.time.LocalDate;

public class VehicleReservationSystem {

    public static void main(String[] args) {

        ReservationSystem system = new ReservationSystem();

        // Create locations
        Location bangalore = new Location("Bangalore", "Koramangala", "Karnataka", "560034");

        // Create users
        User user1 = new User("U001", "DL123456789", "John Doe", "9876543210");


        system.addUser(user1);


        // Create stores
        Store bangaloreStore = new Store("S001", bangalore);

        // Add vehicles to Mumbai store
        bangaloreStore.getStoreManager().add(new Car("V001", "CH001", "KA01AB1234", "Honda City", 15.5, 25000, LocalDate.of(2020, 1, 15)));
        bangaloreStore.getStoreManager().add(new Car("V002", "CH002", "KA01CD5678", "Toyota Camry", 12.0, 30000, LocalDate.of(2019, 6, 20)));
        bangaloreStore.getStoreManager().add(new Bike("V003", "CH003", "KA02EF9012", "Hero Splendor", 60.0, 15000, LocalDate.of(2021, 3, 10)));
        bangaloreStore.getStoreManager().add(new Bike("V004", "CH004", "KA02GH3456", "Honda CB Shine", 55.0, 18000, LocalDate.of(2020, 8, 25)));


        // Add stores to a system
        system.addStore(bangaloreStore);

        // Show initial system status
        system.showSystemStatus();

        // Show all vehicles before reservations
        System.out.println("INITIAL VEHICLE STATUS (Before Reservations):");
        system.showAllStoreVehicles();

        // Make some reservations
        System.out.println("MAKING RESERVATIONS:");
        System.out.println("═══════════════════════════");

        LocalDate today = LocalDate.now();

        // Reservation 1: John books Honda City in Bangalore
        Reservation r1 = system.bookVehicle("U001", "S001", "V002",
                today.plusDays(1), today.plusDays(4),
                "Bangalore", "Bangalore");

        // Show vehicles after reservations
        System.out.println("VEHICLE STATUS AFTER RESERVATIONS:");
        system.showAllStoreVehicles();

        // Show all reservations
        System.out.println("ALL RESERVATIONS:");
        bangaloreStore.showReservations();

        // Complete one reservation
        if (r1 != null) {
            System.out.println("COMPLETING RESERVATION:");
            r1.completeReservation();
        }

        // Show final vehicle status
        System.out.println("FINAL VEHICLE STATUS:");
        system.showAllStoreVehicles();

        // Final system status
        system.showSystemStatus();

    }
}
