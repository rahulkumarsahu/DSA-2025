package com.dsa2025.learn.lld.questions.designCarRentalSystem.model.user;

public class User {

    private String id;
    private String drivingLicense;
    private String userName;
    private String phoneNumber;

    public User(String id, String drivingLicense, String userName, String phoneNumber) {
        this.id = id;
        this.drivingLicense = drivingLicense;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getId() { return id; }
    public String getUserName() { return userName; }
    public String getDrivingLicense() { return drivingLicense; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setId(String id) {
        this.id = id;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return userName + " (" + id + ")";
    }

}
