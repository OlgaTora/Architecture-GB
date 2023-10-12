package lesson1.store.modelelements;

import java.util.Collection;

public class Flash {

    //region Constructors

    public Flash(Point3D location, double angle, String color, double power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Flash(Point3D location, String color, double power) {
        this.location = location;
        this.color = color;
        this.power = power;
    }
//endregion
    //region Public Properties

    public void rotate(double angle) {
    }

    public void move(Point3D location) {
    }

    public Point3D getLocation() {
        return location;
    }

    public double getAngle() {
        return angle;
    }

    public String getColor() {
        return color;
    }

    public double getPower() {
        return power;
    }
    //endregion
    //region Private Fields

    private Point3D location;

    private double angle = 90.0;

    private String color;

    private double power;
//endregion
}

