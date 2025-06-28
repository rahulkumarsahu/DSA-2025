package com.dsa2025.learn.lld.designPatterns.flywieght.robot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RoboticFactory {

    private static Map<String, IRobot> roboticObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType){

        if(roboticObjectCache.containsKey(robotType)){
            return roboticObjectCache.get(robotType);
        }
        else {
            if(Objects.equals(robotType, "HUMANOID")){
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidObject = new HumanoidRobot(robotType, humanoidSprite);
                roboticObjectCache.put(robotType, humanoidObject);
                return humanoidObject;
            }
            else if(Objects.equals(robotType, "ROBOTICDOG")){
                Sprites roboticDogSprite = new Sprites();
                IRobot roboticDogObject = new RoboticDog(robotType, roboticDogSprite);
                roboticObjectCache.put(robotType, roboticDogObject);
                return roboticDogObject;
            }
        }
        return null;
    }
}
