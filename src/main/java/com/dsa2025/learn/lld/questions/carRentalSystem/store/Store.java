package com.dsa2025.learn.lld.questions.carRentalSystem.store;

import com.dsa2025.learn.lld.questions.carRentalSystem.model.location.Location;
import com.dsa2025.learn.lld.questions.carRentalSystem.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private String id;
    private Location location;
    private StoreManager storeManager;
    private List<Reservation> reservations;

    public Store(String id, Location location) {
        this.id = id;
        this.location = location;
        this.storeManager = new StoreManager();
        this.reservations = new ArrayList<>();
    }

    public String getId() { return id; }
    public Location getLocation() { return location; }
    public StoreManager getStoreManager() { return storeManager; }
    public List<Reservation> getReservations() { return reservations; }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setStoreManager(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> reservation() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void showReservations() {
        System.out.println("RESERVATIONS for " + location.getCity() + ":");
        if (reservations.isEmpty()) {
            System.out.println(" No reservations found");
        } else {
            for (Reservation r : reservations) {
                System.out.println("  " + r);
            }
        }
    }
}
