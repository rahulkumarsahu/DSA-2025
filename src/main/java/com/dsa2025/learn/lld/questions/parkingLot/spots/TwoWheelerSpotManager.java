package com.dsa2025.learn.lld.questions.parkingLot.spots;

import com.dsa2025.learn.lld.questions.parkingLot.strategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager {

    public TwoWheelerSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy strategy) {
        super(parkingSpots, strategy);
    }

    /**
     * This method will be used to add the parking space based on type 2-wheeler or 4-wheeler
     * it should add parking space in an existing list of 2-wheeler
     * @param parkingSpot parkingSpot
     * @return Boolean
     */
    @Override
    public Boolean addParkingSpace(ParkingSpot parkingSpot) {

        if (parkingSpot instanceof TwoWheelerSpot) {
            return getParkingSpotList().add(parkingSpot);
        }

        return Boolean.FALSE;
    }

    /**
     * This method will be used to remove the parking space based on type 2-wheeler or 4-wheeler
     * it should remove parking space in an existing list of 2-wheeler
     *
     * @param parkingSpot parkingSpot
     * @return Boolean
     */
    @Override
    public Boolean removeParkingSpace(ParkingSpot parkingSpot) {

        return getParkingSpotList().remove(parkingSpot);
    }
}
