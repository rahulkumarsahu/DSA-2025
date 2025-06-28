package com.dsa2025.learn.lld.questions.parkingLot.dto;

import com.dsa2025.learn.lld.questions.parkingLot.constant.VehicleType;

/**
 * This class will be used to hold vehicle properties that are parked in Vehicle
 * @param vehicleNo
 * @param vehicleType
 */
public record Vehicle(String vehicleNo, VehicleType vehicleType) {

}
