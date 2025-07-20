package com.dsa2025.learn.lld.questions.carRentalSystem.model.location;

public class Location {
    private String city;
    private String address;
    private String state;
    private String pinCode;

    public Location(String city, String address, String state, String pinCode) {
        this.city = city;
        this.address = address;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getCity() { return city; }
    public String getAddress() { return address; }
    public String getState() { return state; }
    public String getPinCode() { return pinCode; }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String toString() {
        return city + ", " + state;
    }

}
