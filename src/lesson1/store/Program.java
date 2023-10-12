package lesson1.store;

import lesson1.store.inmemorymodel.CustomService1;
import lesson1.store.inmemorymodel.CustomService2;
import lesson1.store.inmemorymodel.CustomService3;
import lesson1.store.inmemorymodel.ModelStore;
import lesson1.store.modelelements.*;

import java.util.ArrayList;
import java.util.Collection;

public class Program {

    public static void main(String[] args) {
        Texture texture1 = new Texture("texture 1");
        Texture texture2 = new Texture("texture 2");

        Point3D point1 = new Point3D(1, 1, 1);
        Point3D point2 = new Point3D(2, 2, 2);
        Point3D point3 = new Point3D(3, 3, 3);

        Collection<Point3D> points1 = new ArrayList<>();
        points1.add(point1);
        points1.add(point2);
        Poligon poligon1 = new Poligon(points1);
        Collection<Point3D> points2 = new ArrayList<>();
        points1.add(point2);
        points1.add(point3);
        Poligon poligon2 = new Poligon(points2);
        Collection<Poligon> poligons = new ArrayList<>();
        poligons.add(poligon1);
        poligons.add(poligon2);

        PoligonalModel model1 = new PoligonalModel(poligons);
        Collection<PoligonalModel> models = new ArrayList<>();
        models.add(model1);

        Flash flash1 = new Flash(point1, "green", 100.0);
        Flash flash2 = new Flash(point2, "red", 50.0);
        Collection<Flash> flashes = new ArrayList<>();
        flashes.add(flash1);
        flashes.add(flash2);

        Camera camera1 = new Camera(point2);
        Camera camera2 = new Camera(point3);
        Collection<Camera> cameras = new ArrayList<>();
        cameras.add(camera1);
        cameras.add(camera2);

        Scene scene1= new Scene(models, flashes, cameras);
        Collection<Scene> scenes = new ArrayList<>();
        scenes.add(scene1);

        CustomService1 observer1 = new CustomService1();
        CustomService2 observer2 = new CustomService2();
        CustomService3 observer3 = new CustomService3();

        ModelStore modelStore = new ModelStore(models, flashes, cameras, scenes);
        modelStore.registerModelChanger(observer1);
        modelStore.registerModelChanger(observer2);
        modelStore.registerModelChanger(observer3);
    }

}
