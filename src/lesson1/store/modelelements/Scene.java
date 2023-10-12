package lesson1.store.modelelements;

import java.util.Collection;

public class Scene {

    //region Constructors
    public Scene(Collection<PoligonalModel> models, Collection<Flash> flashes, Collection<Camera> cameras) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    public Scene() {
    }

    {
        id = ++counter;
    }
    //endregion

    //region Public Properties

    public static Collection<PoligonalModel> method1(Collection<PoligonalModel> model) {
        return model;
    }

    public static Collection<PoligonalModel> method2(Collection<PoligonalModel> model, Collection<Flash> flash) {
        return model;
    }

    public int getId() {
        return id;
    }

    public Collection<PoligonalModel> getModels() {
        return models;
    }

    public void setModels(Collection<PoligonalModel> models) {
        this.models = models;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(Collection<Flash> flashes) {
        this.flashes = flashes;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(Collection<Camera> cameras) {
        this.cameras = cameras;
    }

    //endregion

    //region Private Fields
    private static int counter = 0;
    private int id;
    private Collection<PoligonalModel> models;
    private Collection<Flash> flashes;
    private Collection<Camera> cameras;
    //endregion
}