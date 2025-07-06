package com.dsa2025.learn.lld.questions.designParkingLot.models.spots.manager;

import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.ParkingLotStatus;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking.ParkingStrategy;


import java.util.List;
import java.util.Optional;

/**
 * This class manages the list of parking spots.
 */
public abstract class ParkingSpotManager {

    private final List<ParkingSpot> parkingSpotList;
    private final ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        this.parkingSpotList = parkingSpotList;
        this.parkingStrategy = parkingStrategy;
    }

    /**
     * This method will be used to add the parking space based on type 2-wheeler or 4-wheeler
     * @param parkingSpot parkingSpot
     * @return Boolean
     */
    public abstract Boolean addParkingSpace(ParkingSpot parkingSpot);

    /**
     * This method will be used to remove the parking space based on type 2-wheeler or 4-wheeler
     * @param parkingSpot parkingSpot
     * @return Boolean
     */
    public abstract Boolean removeParkingSpace(ParkingSpot parkingSpot);

    /**
     * This method will be used to find a parking spot based on strategy
     * @return Optional<ParkingSpot>
     */
    public Optional<ParkingSpot> findParkingSpot() {
        // based on parking strategy near to entrance or near to entrance and elevator or random strategy,
        // we will find the spot for our vehicle
        return parkingStrategy.findSpot(parkingSpotList);
    }

    /**
     * This method will be used to park the vehicle based on type and size
     * @param vehicle vehicle
     * @return Boolean
     */
    public Boolean requestParkVehicle(ParkingSpot availableSpot, Vehicle vehicle) {
        // if unable to park vehicle return False else return true
        return availableSpot.parkVehicle(vehicle);
    }

    /**
     * This method will be used to remove the parked vehicle based on type and size
     * @param vehicleNo vehicleNo.
     * @return Boolean
     */
    public Optional<Vehicle> requestRemoveVehicle(String vehicleNo) {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            // if it is truer than no vehicle is parked and parked vehicle should be equal to vehicleNo.
            if (parkingSpot.getParkingLotStatus() != ParkingLotStatus.EMPTY
                    && parkingSpot.getVehicle().getVehicleRegistrationNumber().equalsIgnoreCase(vehicleNo)) {
                return parkingSpot.removeVehicle();
            }
        }
        return Optional.empty();
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }


}
