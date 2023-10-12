package lesson1.store.modelelements;

import java.util.ArrayList;
import java.util.Collection;

public class Poligon {

    //region Constructors
    public Poligon(Collection<Point3D> points) {
        this.points = points;
    }

    public Poligon() {
    }

    //endregion
    //region Public Properties
    public Collection<Point3D> getPoints() {
        return points;
    }
    //endregion
    //region Private Fields
    private Collection<Point3D> points = new ArrayList<>();

    //endregion
}
