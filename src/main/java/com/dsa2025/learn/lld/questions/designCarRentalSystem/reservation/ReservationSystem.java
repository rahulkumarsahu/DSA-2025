package com.dsa2025.learn.lld.questions.designCarRentalSystem.reservation;

import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.user.User;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.vehicle.Vehicle;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.store.Store;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReservationSystem {

    private Map<String, Store> stores;
    private Map<String, User> users;
    private int reservationCounter;

    public void setStores(Map<String, Store> stores) {
        this.stores = stores;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public int getReservationCounter() {
        return reservationCounter;
    }

    public void setReservationCounter(int reservationCounter) {
        this.reservationCounter = reservationCounter;
    }

    public ReservationSystem() {
        this.stores = new HashMap<>();
        this.users = new HashMap<>();
        this.reservationCounter = 1;
    }

    public Map<String, Store> getStores() { return stores; }
    public Map<String, User> getUsers() { return users; }

    public void addStore(Store store) {
        stores.put(store.getId(), store);
        System.out.println("🏪 Store added: " + store.getLocation().getCity());
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
        System.out.println("👤 User registered: " + user.getUserName());
    }

    public Reservation bookVehicle(String userId, String storeId, String vehicleId,
                                   LocalDate bookFrom, LocalDate bookTill,
                                   String pickupCity, String dropCity) {
        User user = users.get(userId);
        Store store = stores.get(storeId);

        if (user == null || store == null) {
            System.out.println("User or Store not found!");
            return null;
        }

        Vehicle vehicle = store.getStoreManager().findVehicle(vehicleId);
        if (vehicle == null) {
            System.out.println("Vehicle not found!");
            return null;
        }

        String reservationId = "R" + reservationCounter++;
        Reservation reservation = new Reservation(reservationId, user, vehicle,
                bookFrom, bookTill,
                store.getLocation(), store.getLocation());

        reservation.createReserve();
        store.addReservation(reservation);

        return reservation;
    }

    public void showSystemStatus() {
        System.out.println("CAR RENTAL SYSTEM STATUS");
        System.out.println("═══════════════════════════════");
        System.out.println("Total Stores: " + stores.size());
        System.out.println("Total Users: " + users.size());

        int totalVehicles = 0;
        int totalReservations = 0;
        for (Store s : stores.values()) {
            totalVehicles += s.getStoreManager().getVehicles().size();
            totalReservations += s.getReservations().size();
        }
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Reservations: " + totalReservations);
        System.out.println("═══════════════════════════════");
    }

    public void showAllStoreVehicles() {
        for (Store store : stores.values()) {
            System.out.println("STORE: " + store.getLocation().getCity());
            store.getStoreManager().showRemainingVehicles();
        }
    }

}
