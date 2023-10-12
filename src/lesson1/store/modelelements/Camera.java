package lesson1.store.modelelements;

import java.util.Collection;

public class Camera {

    //region Constructors
    public Camera(Point3D location, double angle) {
        this.location = location;
        this.angle = angle;
    }

    public Camera(Point3D location) {
        this.location = location;
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
    //endregion
    //region Private Fields

    private Point3D location;

    private double angle;
//endregion
}