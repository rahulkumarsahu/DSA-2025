package com.dsa2025.learn.lld.designPatterns.adapterPattern.client;

import com.dsa2025.learn.lld.designPatterns.adapterPattern.adaptee.WeightMachineForBabies;
import com.dsa2025.learn.lld.designPatterns.adapterPattern.adapter.WeightMachineAdapter;
import com.dsa2025.learn.lld.designPatterns.adapterPattern.adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String[] args) {
        // client wants weight in KG that is why....
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
