package lesson1.store.inmemorymodel;

import lesson1.store.modelelements.Camera;
import lesson1.store.modelelements.Flash;
import lesson1.store.modelelements.PoligonalModel;
import lesson1.store.modelelements.Scene;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements ModelChanger {
    //region Constructors

    public ModelStore(Collection<PoligonalModel> models, Collection<Flash> flashes, Collection<Camera> cameras, Collection<Scene> scenes) {
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
        this.scenes = scenes;
    }

    public ModelStore() {
    }
//endregion
    //region Public Properties

    /**
     * Нотифицирует о событии
     */
    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : changeObservers) {
            observer.applyUpdateModel();
        }
    }

    public Collection<Scene> getScenes() {
        return scenes;
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }
    //endregion
    //region Private Fields

    private Collection<PoligonalModel> models;
    private Collection<Flash> flashes;
    private Collection<Camera> cameras;
    private Collection<Scene> scenes;
    private Collection<ModelChangedObserver> changeObservers = new ArrayList<>();

//endregion
}
