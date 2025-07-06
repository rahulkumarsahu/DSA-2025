package com.dsa2025.learn.lld.questions.designParkingLot.models.spots.manager;

import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.FourWheelerWithChargingParkingSpot;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking.ParkingStrategy;

import java.util.List;

public class FourWheelerWithChargingParkingSpotManager extends ParkingSpotManager {

    public FourWheelerWithChargingParkingSpotManager(List<ParkingSpot> parkingSpotList,
                                                     ParkingStrategy parkingStrategy) {
        super(parkingSpotList, parkingStrategy);
    }

    /**
     * This method will be used to add the parking space based on type 2-wheeler or 4-wheeler
     *
     * @param parkingSpot parkingSpot
     * @return Boolean
     */
    @Override
    public Boolean addParkingSpace(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof FourWheelerWithChargingParkingSpot) {
            return super.getParkingSpotList().add(parkingSpot);
        }
       return Boolean.FALSE;
    }

    /**
     * This method will be used to remove the parking space based on type 2-wheeler or 4-wheeler
     *
     * @param parkingSpot parkingSpot
     * @return Boolean
     */
    @Override
    public Boolean removeParkingSpace(ParkingSpot parkingSpot) {
        return super.getParkingSpotList().remove(parkingSpot);
    }
}
