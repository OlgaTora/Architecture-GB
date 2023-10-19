package lesson3;

import java.awt.*;

public class CivilianVehicle extends Car {
    public CivilianVehicle(String make, String model, Color color) {
        super(make, model, color);
        setGearboxType(GearboxType.AT);
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
