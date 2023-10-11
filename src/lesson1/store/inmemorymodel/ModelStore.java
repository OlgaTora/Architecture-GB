package lesson1.store.inmemorymodel;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements ModelChanger {
    //TODO: Доработать в рамках домашней работы

    private Collection<ModelChangedObserver> changeObservers = new ArrayList<>();

    /**
     * Нотифицирует о событии
     */
    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : changeObservers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }
}
