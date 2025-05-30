package com.dsa2025.learn.lld.designPatterns.flywieght;

public class Main {

    public static void main(String[] args){

        IRobot humanoidRobot1 = RoboticFactory.createRobot("HUMANOID");
        assert humanoidRobot1 != null;
        humanoidRobot1.display(1,2);


        IRobot humanoidRobot2 = RoboticFactory.createRobot("HUMANOID");
        assert humanoidRobot2 != null;
        humanoidRobot2.display(10,30);

        IRobot roboDog1 = RoboticFactory.createRobot("ROBOTICDOG");
        assert roboDog1 != null;
        roboDog1.display(2,9);

        IRobot roboDog2 = RoboticFactory.createRobot("ROBOTICDOG");
        assert roboDog2 != null;
        roboDog2.display(11,19);

    }
}
