package com.dsa2025.learn.lld.questions.designCarRentalSystem.reservation;

import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.enums.ReservationStatus;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.enums.VehicleType;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.location.Location;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.payment.Bill;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.payment.Payment;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.user.User;
import com.dsa2025.learn.lld.questions.designCarRentalSystem.model.vehicle.Vehicle;

import java.time.LocalDate;

public class Reservation {

    private String id;
    private Location location;
    private User user;
    private Vehicle vehicle;
    private Bill bill;
    private Payment payment;
    private LocalDate bookingDate;
    private LocalDate bookFrom;
    private LocalDate bookTill;
    private Location pickupLocation;
    private Location dropLocation;
    private ReservationStatus status;

    public Reservation(String id, User user, Vehicle vehicle, LocalDate bookFrom,
                       LocalDate bookTill, Location pickupLocation, Location dropLocation) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = LocalDate.now();
        this.bookFrom = bookFrom;
        this.bookTill = bookTill;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = ReservationStatus.PENDING;

        // Calculate price
        long days = bookTill.toEpochDay() - bookFrom.toEpochDay();
        double dailyRate = (vehicle.getVehicleType() == VehicleType.CAR) ? 1500 : 800;
        double totalPrice = days * dailyRate;

        this.bill = new Bill("B" + id, totalPrice);
        this.payment = new Payment("P" + id, totalPrice, "Credit Card");
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Vehicle getVehicle() { return vehicle; }
    public Bill getBill() { return bill; }
    public ReservationStatus getStatus() { return status; }
    public void setStatus(ReservationStatus status) { this.status = status; }
    public LocalDate getBookFrom() { return bookFrom; }
    public LocalDate getBookTill() { return bookTill; }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookFrom(LocalDate bookFrom) {
        this.bookFrom = bookFrom;
    }

    public void setBookTill(LocalDate bookTill) {
        this.bookTill = bookTill;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public void createReserve() {
        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle not available for reservation!");
            return;
        }
        // reserve the vehicle
        vehicle.reserve();
        // process the payment
        payment.processPayment();
        // generate the bill
        bill.generateBill();

        this.status = ReservationStatus.CONFIRMED;

        System.out.println("Reservation created successfully!");
        System.out.println("Reservation ID: " + id);
        System.out.println("User: " + user.getUserName());
        System.out.println("Vehicle: " + vehicle.getModelName());
        System.out.println("Period: " + bookFrom + " to " + bookTill);
        System.out.println("Amount: ₹" + bill.getPrice());
    }

    public void cancelReservation() {
        if (status == ReservationStatus.CONFIRMED) {
            vehicle.release();
            this.status = ReservationStatus.CANCELLED;
            System.out.println("Reservation " + id + " cancelled!");
        }
    }

    public void completeReservation() {
        if (status == ReservationStatus.CONFIRMED) {
            vehicle.release();
            this.status = ReservationStatus.COMPLETED;
            System.out.println("Reservation " + id + " completed!");
        }
    }

    public String toString() {
        return String.format("[%s] %s | %s | %s to %s | %s | ₹%.0f",
                id, user.getUserName(), vehicle.getModelName(),
                bookFrom, bookTill, status, bill.getPrice());
    }
}
