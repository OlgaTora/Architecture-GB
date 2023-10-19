package lesson3;

import java.awt.*;

public class Harvester extends Car {


    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
        setFuelType(FuelType.Diesel);
    }

    private boolean fogLights = false;

    public boolean switchFogLights() {
        fogLights = !fogLights;
        return fogLights;
    }


    public void sweeping() {
        System.out.println("Автомобиль метет улицу.");
    }

    @Override
    public void movement() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }


}